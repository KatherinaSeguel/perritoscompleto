package cl.cristianvidal.dogsmobdevapp.breedList.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.cristianvidal.dogsmobdevapp.R

class BreedListAdapter : RecyclerView.Adapter<BreedListAdapter.BreedListAdapterHolder>() {

    private val breedlistadapters = arrayListOf<BreedListAdapter>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedListAdapterHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_breed, parent, false)
        return BreedListAdapterHolder(view)
    }

    override fun onBindViewHolder(holder: BreedListAdapterHolder, position: Int) {
        val breedlistadapter = breedlistadapters[position]
    }

    override fun getItemCount(): Int = breedlistadapters.size


    inner class BreedListAdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {

        }

    }

}