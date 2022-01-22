package mehdiparsaei.simonsvoss.assignment.presentation.ui

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.TextAppearanceSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import mehdiparsaei.simonsvoss.assignment.databinding.ItemLockBinding
import mehdiparsaei.simonsvoss.assignment.domain.model.Lock


class MainAdapter :
    ListAdapter<Lock, MainAdapter.ViewHolder>(DiffCallback) {

    var searchQuery = ""
        set(value) {
            field = value
            DiffCallback.searchQuery = value
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLockBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lock = getItem(position)
        holder.bind(lock)
    }

    private fun highLightText(spannable: Spannable, string: String, start: Int) {
        val startIndex =  string.lowercase()
            .indexOf(searchQuery.lowercase())
        if (startIndex > -1) {
            val endIndex = startIndex + searchQuery.length
            spannable.setSpan(ForegroundColorSpan(Color.YELLOW), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }

    inner class ViewHolder(private val binding: ItemLockBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(lock: Lock) {
            binding.apply {
                val lockName = lock.name
                val lockDetail = "${lock.shortCut} - ${lock.floor} - ${lock.roomNumber}"

                if (searchQuery.isNotEmpty()) {
                    val lockNameSpannable = SpannableString(lockName)
                    highLightText(lockNameSpannable, lockName, 0)
                    textViewLockName.text = lockNameSpannable

                    val lockDetailSpannable = SpannableString(lockDetail)
                    highLightText(lockDetailSpannable, lockDetail, 0)
                    textViewDetail.text = lockDetailSpannable
                } else {
                    textViewLockName.text = lockName
                    textViewDetail.text = lockDetail
                }
            }
        }
    }


    object DiffCallback : DiffUtil.ItemCallback<Lock>() {
        var searchQuery = ""
        override fun areItemsTheSame(oldItem: Lock, newItem: Lock) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Lock, newItem: Lock) =
            oldItem == newItem &&
                    !oldItem.name.lowercase().contains(searchQuery.lowercase()) &&
                    !oldItem.roomNumber.lowercase().contains(searchQuery.lowercase()) &&
                    !oldItem.floor.lowercase().contains(searchQuery.lowercase()) &&
                    !oldItem.shortCut?.lowercase()?.contains(searchQuery.lowercase())!!
    }
}