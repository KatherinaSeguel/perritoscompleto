package cl.cristianvidal.dogsmobdevapp.breedImagesList.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.cristianvidal.dogsmobdevapp.R
import cl.cristianvidal.dogsmobdevapp.data.Result
import cl.cristianvidal.dogsmobdevapp.databinding.FragmentBreedImagesBinding
import cl.cristianvidal.dogsmobdevapp.di.Injectable
import cl.cristianvidal.dogsmobdevapp.di.injectViewModel
import cl.cristianvidal.dogsmobdevapp.ui.hide
import cl.cristianvidal.dogsmobdevapp.ui.show
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class BreedImagesFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var breedImagesViewModel: BreedImagesViewModel

    private val args: BreedImagesFragmentArgs by navArgs()

    private val adapterAlternative = BreedImagesAdapterAlternative(mutableListOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.e("ARGS", args.toString())

        breedImagesViewModel = injectViewModel(viewModelFactory)
        breedImagesViewModel.id = args.breeName

        val binding = FragmentBreedImagesBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val recyclerView = binding.root.findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapterAlternative


        subscribeUI(binding, adapterAlternative)

        setHasOptionsMenu(true)
        return binding.root
    }


    private fun subscribeUI(
        binding: FragmentBreedImagesBinding,
        adapter: BreedImagesAdapterAlternative
    ) {

        breedImagesViewModel.breedImages.observe(viewLifecycleOwner, Observer { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    binding.progressBar.hide()
                    result.data?.let {
                        adapter.updateImages(it.first().message)
//                        Log.e("message", it.first().message.toString())
                    }
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