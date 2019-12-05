package cl.cristianvidal.dogsmobdevapp.breedImagesList.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import cl.cristianvidal.dogsmobdevapp.R
import com.squareup.picasso.Picasso

/**
 * Created by Cristian Vidal on 2019-12-04.
 * this try is with view binding
 */
class BreedImagesAdapterAlternative(private val ImagesList: MutableList<String>) :
    RecyclerView.Adapter<BreedImagesAdapterAlternative.BreedImageAlternativeHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedImageAlternativeHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_alternative_image, parent, false)
        return BreedImageAlternativeHolder(view)
    }

    override fun onBindViewHolder(holder: BreedImageAlternativeHolder, position: Int) {
        val breedimagealternative = ImagesList[position]
        Picasso.get().load(breedimagealternative)
            .into(holder.imageView)
        Picasso.get().setIndicatorsEnabled(true)
    }

    override fun getItemCount(): Int = ImagesList.size

    fun updateImages(breedString: List<String>) {
        this.ImagesList.clear()
        this.ImagesList.addAll(breedString)
        notifyDataSetChanged()
    }

    inner class BreedImageAlternativeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageViewBreed)
    }
}