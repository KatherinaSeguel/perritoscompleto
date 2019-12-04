package cl.cristianvidal.dogsmobdevapp.breedImagesList.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import cl.cristianvidal.dogsmobdevapp.databinding.FragmentBreedImagesBinding
import cl.cristianvidal.dogsmobdevapp.di.Injectable
import cl.cristianvidal.dogsmobdevapp.di.injectViewModel
import javax.inject.Inject

class BreedImagesFragment : Fragment(), Injectable {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var breedImagesViewModel: BreedImagesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        breedImagesViewModel = injectViewModel(viewModelFactory)

        val binding = FragmentBreedImagesBinding.inflate(inflater, container,false)
        context ?: return binding.root



        return binding.root
    }
}