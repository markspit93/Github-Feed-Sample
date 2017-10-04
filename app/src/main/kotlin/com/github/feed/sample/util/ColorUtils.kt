package com.github.feed.sample.util

import android.content.Context
import android.support.v4.content.ContextCompat
import com.github.feed.sample.R
import com.github.feed.sample.data.*

object ColorUtils {

    fun getColorForType(context: Context, type: String) =
            ContextCompat.getColor(context, when (type) {
                EVENT_CREATE -> R.color.orange_A700
                EVENT_DELETE -> R.color.purple_A400
                EVENT_FORK -> R.color.green_A700
                EVENT_PULL_REQUEST -> R.color.deep_purple_A400
                EVENT_PUSH -> R.color.red_A400
                EVENT_WATCH -> R.color.indigo_A700
                else -> R.color.colorPrimary
            })
}

