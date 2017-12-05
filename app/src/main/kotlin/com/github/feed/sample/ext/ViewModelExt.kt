package com.github.feed.sample.ext

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

inline fun <reified T : ViewModel> ViewModelProvider.get(): T = get(T::class.java)
