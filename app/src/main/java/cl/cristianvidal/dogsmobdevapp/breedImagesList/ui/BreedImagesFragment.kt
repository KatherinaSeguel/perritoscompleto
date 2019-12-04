package cl.cristianvidal.dogsmobdevapp.breedImagesList.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import cl.cristianvidal.dogsmobdevapp.R

class BreedImagesFragment : Fragment() {

    private lateinit var breedImagesViewModel: BreedImagesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        breedImagesViewModel =
            ViewModelProviders.of(this).get(BreedImagesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_breed_images, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        breedImagesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}