package com.github.feed.sample.ext

import android.view.View
import android.view.animation.AnimationUtils
import com.github.feed.sample.R

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.goneWithAnimation() {
    startAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_to_bottom))
    visibility = View.GONE
}

fun View.isVisible() = visibility == View.VISIBLE
