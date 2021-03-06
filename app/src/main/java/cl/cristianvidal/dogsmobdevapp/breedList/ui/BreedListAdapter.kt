package cl.cristianvidal.dogsmobdevapp.breedList.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cl.cristianvidal.dogsmobdevapp.databinding.ListItemBreedBinding

class BreedListAdapter : ListAdapter<String, BreedListAdapter.ViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val breed = getItem(position)
        holder.apply {
            bind(createOnClickListener(breed), breed)
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

        fun bind(listener: View.OnClickListener, item: String) {
            binding.apply {
                clickListener = listener
                breedListItem = item
                executePendingBindings()
            }
        }
    }


    private fun createOnClickListener(breeName: String): View.OnClickListener {
        return View.OnClickListener {
            val direction = BreedListFragmentDirections.actionBreedListFragmentToBreedImagesFragment(breeName)
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


}