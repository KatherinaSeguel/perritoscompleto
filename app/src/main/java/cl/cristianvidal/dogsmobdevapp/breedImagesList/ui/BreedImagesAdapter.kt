package cl.cristianvidal.dogsmobdevapp.breedImagesList.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cl.cristianvidal.dogsmobdevapp.binding.bindImageFromUrl
import cl.cristianvidal.dogsmobdevapp.breedList.ui.BreedListFragmentDirections
import cl.cristianvidal.dogsmobdevapp.databinding.ListItemImageBinding

/**
 * Created by Cristian Vidal on 2019-12-04.
 * this try is with view binding
 */
class BreedImagesAdapter : ListAdapter<String, BreedImagesAdapter.ViewHolder>(DiffCallback()) {

    private lateinit var recyclerView: RecyclerView

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val breed = getItem(position)
        holder.apply {
            bind(createOnClickListener(breed), breed)
            itemView.tag = breed
            bindView(ListItemImageBinding.bind(itemView), breed )

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    class ViewHolder(
        private val binding: ListItemImageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: String) {
            binding.apply {
                breedImage = item
                executePendingBindings()
            }

        }
    }


    private fun createOnClickListener(breeName: String): View.OnClickListener {
        return View.OnClickListener {
            val direction =
                BreedListFragmentDirections.actionBreedListFragmentToBreedImagesFragment(breeName)
            it.findNavController().navigate(direction)
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<String>() {

        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    private fun bindView(binding: ListItemImageBinding, image: String) {
        image.apply {
            bindImageFromUrl(binding.image, image)
        }
    }


}