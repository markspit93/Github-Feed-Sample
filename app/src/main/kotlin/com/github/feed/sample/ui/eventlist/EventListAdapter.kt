package com.github.feed.sample.ui.eventlist

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.feed.sample.R
import com.github.feed.sample.data.*
import com.github.feed.sample.data.model.Event
import com.github.feed.sample.data.model.EventList
import com.github.feed.sample.util.debugLog

class EventListAdapter(private val eventClick: (Event) -> Unit) : RecyclerView.Adapter<EventListViewHolder>() {

    companion object {
        private const val EXTRA_PAYLOAD_EVENT = "extra_payload_event"
    }

    private val items = mutableListOf<EventList>()
    private val filteredItems = mutableListOf<EventList>()
    private val filterTypes = mutableListOf(EVENT_CREATE, EVENT_DELETE, EVENT_FORK, EVENT_PULL_REQUEST, EVENT_PUSH, EVENT_WATCH)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventListViewHolder {
        return EventListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_event_list, parent, false), eventClick)
    }

    override fun onBindViewHolder(holder: EventListViewHolder, position: Int) {
        holder.bindItem(filteredItems[position])
    }

    override fun onBindViewHolder(holder: EventListViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position)
        } else {
            val payload: Bundle = payloads[0] as Bundle
            holder.addEvent(payload.getParcelable(EXTRA_PAYLOAD_EVENT))
        }
    }

    override fun getItemCount() = filteredItems.size

    fun addEvent(event: Event) {
        items.indices
                .filter { items[it].type == event.type }
                .forEach { items[it].events.add(0, event) }

        for ((index, eventList) in filteredItems.withIndex()) {
            if (eventList.type == event.type) {
                eventList.events.add(0, event)

                if (filterTypes.contains(event.type)) {
                    notifyItemChanged(index, Bundle().apply { putParcelable(EXTRA_PAYLOAD_EVENT, event) })
                }
                return
            }
        }

        items.add(EventList(event.type, mutableListOf(event)))

        if (filterTypes.contains(event.type)) {
            filteredItems.add(EventList(event.type, mutableListOf(event)))
            if (filteredItems.size == 1) {
                notifyDataSetChanged()
            } else {
                notifyItemInserted(filteredItems.lastIndex)
            }
            return
        }
    }

    fun filterType(type: String) {
        filterTypes.remove(type)

        for ((index, eventList) in filteredItems.withIndex()) {
            if (eventList.type == type) {
                filteredItems.removeAt(index)
                notifyItemRemoved(index)
                return
            }
        }
    }

    fun unfilterType(type: String) {
        filterTypes.add(type)

        items.forEach {
            if (it.type == type) {
                debugLog("LOL " + it.type)
                filteredItems.add(0, it)
                notifyItemInserted(0)
                return
            }
        }
    }
}
