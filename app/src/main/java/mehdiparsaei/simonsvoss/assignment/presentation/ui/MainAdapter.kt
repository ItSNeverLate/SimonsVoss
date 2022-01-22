package mehdiparsaei.simonsvoss.assignment.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import mehdiparsaei.simonsvoss.assignment.databinding.ItemLockBinding
import mehdiparsaei.simonsvoss.assignment.domain.model.Lock

class MainAdapter :
    ListAdapter<Lock, MainAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLockBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lock = getItem(position)
        holder.bind(lock)
    }

    inner class ViewHolder(private val binding: ItemLockBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(lock: Lock) {
            binding.apply {
                textViewLockName.text = lock.name
                textViewDetail.text =
                    "${lock.shortCut} - ${lock.floor} - ${lock.roomNumber}"
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Lock>() {
        override fun areItemsTheSame(oldItem: Lock, newItem: Lock) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Lock, newItem: Lock) =
            oldItem == newItem
    }
}