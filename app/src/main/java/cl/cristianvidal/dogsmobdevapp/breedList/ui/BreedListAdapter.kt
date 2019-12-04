package cl.cristianvidal.dogsmobdevapp.breedList.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cl.cristianvidal.dogsmobdevapp.breedList.data.Breed
import cl.cristianvidal.dogsmobdevapp.databinding.ListItemBreedBinding

class BreedListAdapter : ListAdapter<Breed, BreedListAdapter.ViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val breed = getItem(position)
        holder.apply {
            bind(createOnClickListener(breed.id), breed)
            itemView.tag = breed
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemBreedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    class ViewHolder(
        private val binding: ListItemBreedBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Breed) {
            binding.apply {
                clickListener = listener
                breedListItem = item
                executePendingBindings()
            }
        }
    }


    private fun createOnClickListener(id: Long): View.OnClickListener {
        return View.OnClickListener {
//            val direction = BreedImagesFragment.(id, name)
//            it.findNavController().navigate(direction)
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<Breed>() {

        override fun areItemsTheSame(oldItem: Breed, newItem: Breed): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Breed, newItem: Breed): Boolean {
            return oldItem == newItem
        }
    }


}