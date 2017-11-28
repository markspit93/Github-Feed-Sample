package com.github.feed.sample.ui.main

import com.github.feed.sample.ui.common.mvp.MvpView

interface MainContract {

    interface View : MvpView {

        fun selectFilter(tag: String)
    }

    interface Presenter {

        fun loadFilterSelections()

        fun saveFilterSelection(tag: String, checked: Boolean)
    }
}
