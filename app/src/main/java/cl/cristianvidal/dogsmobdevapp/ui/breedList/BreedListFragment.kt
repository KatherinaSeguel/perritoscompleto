package cl.cristianvidal.dogsmobdevapp.ui.breedList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import cl.cristianvidal.dogsmobdevapp.R

class BreedListFragment : Fragment() {

    private lateinit var breedListViewModel: BreedListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        breedListViewModel =
            ViewModelProviders.of(this).get(BreedListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_breed_list, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        breedListViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}