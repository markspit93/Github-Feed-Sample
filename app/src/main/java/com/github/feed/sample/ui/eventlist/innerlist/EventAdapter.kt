package com.github.feed.sample.ui.eventlist.innerlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.feed.sample.R
import com.github.feed.sample.data.model.Event

class EventAdapter(private val items: MutableList<Event>,
                   private val color: Int,
                   private val eventClick: (Event) -> Unit) : RecyclerView.Adapter<EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false), color, onEventClick)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount() = items.size

    private val onEventClick: (Int) -> Unit = {
        position -> eventClick(items[position])
    }

    fun addEvent(event: Event) {
        items.add(0, event)
        notifyItemInserted(0)
    }
}
