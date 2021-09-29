package com.github.feed.sample.util

import android.content.Context
import com.github.feed.sample.R
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    fun formatDate(ctx: Context, date: String): String {
        var formattedDate: String

        try {
            var format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
            val newDate = format.parse(date)

            format = SimpleDateFormat("MMM dd, hh:mma", Locale.getDefault())
            formattedDate = format.format(newDate)
        } catch (e: Exception) {
            formattedDate = ctx.getString(R.string.unavailable)
        }

        return formattedDate
    }
}