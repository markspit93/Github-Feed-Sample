package com.github.feed.sample.ui.eventlist.innerlist

import android.support.v7.widget.RecyclerView
import android.view.View
import com.github.feed.sample.data.model.Event
import com.github.feed.sample.ext.loadCircleImage
import kotlinx.android.synthetic.main.item_event.view.*

class EventViewHolder(itemView: View,
                      private val color: Int,
                      private val func: (position: Int) -> Unit) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    fun bindItem(event: Event) {
        itemView.imgAvatar.loadCircleImage(event.actor.avatar)

        itemView.txtUsername.text = event.actor.username
        itemView.txtUsername.setBackgroundColor(color)

        itemView.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        func(adapterPosition)
    }
}
