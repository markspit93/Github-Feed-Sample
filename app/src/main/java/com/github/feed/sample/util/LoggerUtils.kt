package com.github.feed.sample.util

import android.util.Log
import com.github.feed.sample.BuildConfig

fun debugLog(text: String) {
    if (BuildConfig.DEBUG_MODE) {
        Log.d("GithubFeedSample", text)
    }
}
