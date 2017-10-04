package com.github.feed.sample.ext

import android.content.res.ColorStateList
import android.support.annotation.ColorRes
import android.support.v4.widget.CompoundButtonCompat
import android.widget.CheckBox

fun CheckBox.setButtonTintColor(@ColorRes colorId: Int) {
    val color = context.getColorCompat(colorId)

    val states = arrayOf(intArrayOf(android.R.attr.state_checked), intArrayOf())
    val colors = intArrayOf(color, color)

    CompoundButtonCompat.setButtonTintList(this, ColorStateList(states, colors))
}
