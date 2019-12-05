package cl.cristianvidal.dogsmobdevapp.breedList.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import cl.cristianvidal.dogsmobdevapp.R
import cl.cristianvidal.dogsmobdevapp.data.Result
import cl.cristianvidal.dogsmobdevapp.databinding.FragmentBreedListBinding
import cl.cristianvidal.dogsmobdevapp.di.Injectable
import cl.cristianvidal.dogsmobdevapp.di.injectViewModel
import cl.cristianvidal.dogsmobdevapp.ui.VerticalItemDecoration
import cl.cristianvidal.dogsmobdevapp.ui.hide
import cl.cristianvidal.dogsmobdevapp.ui.show
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class BreedListFragment : Fragment(), Injectable {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var breedListViewModel: BreedListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        breedListViewModel = injectViewModel(viewModelFactory)

        val binding = FragmentBreedListBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = BreedListAdapter()
        binding.recyclerViewBreed.addItemDecoration(
            VerticalItemDecoration(
                resources.getDimension(R.dimen.activity_vertical_margin).toInt(),
                true
            )
        )
        binding.recyclerViewBreed.adapter = adapter
        subscribeUI(binding, adapter)

        setHasOptionsMenu(true)
        return binding.root
    }


    private fun subscribeUI(binding: FragmentBreedListBinding, adapter: BreedListAdapter) {

        breedListViewModel.breedList.observe(viewLifecycleOwner, Observer { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    binding.progressBar.hide()
                    result.data?.let {
                        adapter.submitList(it[0].message) }
                }
                Result.Status.LOADING -> binding.progressBar.show()
                Result.Status.ERROR -> {
                    binding.progressBar.hide()
                    Snackbar.make(binding.root, result.message!!, Snackbar.LENGTH_LONG).show()
                }
            }
        })

    }
}