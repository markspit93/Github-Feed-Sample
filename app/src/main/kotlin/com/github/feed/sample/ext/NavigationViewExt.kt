package com.github.feed.sample.ext

import android.support.annotation.IdRes
import android.support.design.widget.NavigationView
import android.widget.CheckBox

fun NavigationView.findCheckbox(@IdRes viewId: Int): CheckBox {
    return menu.findItem(viewId).actionView as CheckBox
}
