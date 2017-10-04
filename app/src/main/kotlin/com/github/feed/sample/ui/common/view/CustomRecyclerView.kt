package com.github.feed.sample.ui.common.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet

class CustomRecyclerView : RecyclerView {

    private var decorations = 0

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun addItemDecoration(decor: ItemDecoration) {
        super.addItemDecoration(decor)
        decorations++
    }

    override fun removeItemDecoration(decor: ItemDecoration?) {
        super.removeItemDecoration(decor)
        decorations--
    }

    fun getItemDecorationCount() = decorations
}