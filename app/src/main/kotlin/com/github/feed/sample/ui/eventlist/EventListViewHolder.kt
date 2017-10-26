package com.github.feed.sample.ui.eventlist

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.github.feed.sample.R
import com.github.feed.sample.data.*
import com.github.feed.sample.data.model.Event
import com.github.feed.sample.data.model.EventList
import com.github.feed.sample.ui.eventlist.innerlist.EventAdapter
import com.github.feed.sample.ui.eventlist.innerlist.EventItemDecoration
import com.github.feed.sample.util.ColorUtils
import kotlinx.android.synthetic.main.item_event_list.view.*

class EventListViewHolder(itemView: View, private val eventClick: (Event) -> Unit) : RecyclerView.ViewHolder(itemView) {

    private val context = itemView.context
    private lateinit var eventAdapter: EventAdapter

    fun bindItem(eventList: EventList) {
        itemView.txtEventType.text = context.getString(when (eventList.type) {
            EVENT_CREATE -> R.string.event_create
            EVENT_DELETE -> R.string.event_delete
            EVENT_FORK -> R.string.event_fork
            EVENT_PUSH -> R.string.event_push
            EVENT_PULL_REQUEST -> R.string.event_pull_request
            EVENT_WATCH -> R.string.event_watch
            else -> R.string.event_none
        })

        val color = ColorUtils.getColorForType(context, eventList.type)

        itemView.txtEventType.setTextColor(color)

        eventAdapter = EventAdapter(eventList.events, color, eventClick)

        itemView.eventRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = eventAdapter
            setHasFixedSize(true)
            smoothScrollToPosition(0)

            if (itemDecorationCount == 0) {
                addItemDecoration(EventItemDecoration(context))
            }
        }
    }

    fun addEvent(event: Event) {
        eventAdapter.addEvent(event)
        itemView.eventRecyclerView.smoothScrollToPosition(0)
    }
}
