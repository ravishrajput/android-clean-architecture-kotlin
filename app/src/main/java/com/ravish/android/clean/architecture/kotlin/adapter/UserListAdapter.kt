package com.ravish.android.clean.architecture.kotlin.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ravish.android.clean.architecture.kotlin.databinding.LayoutUserListItemBinding
import com.ravish.android.clean.architecture.kotlin.delegates.BoundHolder
import com.ravish.android.clean.architecture.kotlin.delegates.viewBinding
import com.ravish.android.clean.architecture.kotlin.models.User

class UserListAdapter(private val listItemClickListener: ListItemClickListener) :
    ListAdapter<User, UserListAdapter.Holder>(DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(parent)

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            listItemClickListener.onItemClick(getItem(position))
        }
        return holder.bind(getItem(position))
    }

    class Holder(parent: ViewGroup) :
        BoundHolder<LayoutUserListItemBinding>(parent.viewBinding(LayoutUserListItemBinding::inflate)) {

        fun bind(item: User) {
            with(binding) {
                liTextName.text = item.name
                liTextEmail.text = item.email
            }
        }
    }

    object DiffCallBack : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem.id == newItem.id && oldItem.email == newItem.email

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem == newItem
    }
}

interface ListItemClickListener {
    fun onItemClick(user: User)
}