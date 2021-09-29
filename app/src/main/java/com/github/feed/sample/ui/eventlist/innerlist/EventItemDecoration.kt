package com.github.feed.sample.ui.eventlist.innerlist

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import org.jetbrains.anko.dip

class EventItemDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private val sideOffset: Int = context.dip(16f)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        val position = parent.getChildAdapterPosition(view)

        if (position == 0) {
            outRect.left = sideOffset
        } else if (position == parent.adapter.itemCount - 1) {
            outRect.right = sideOffset
        }
    }
}