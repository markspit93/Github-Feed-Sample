package com.github.feed.sample.ui.main

import com.github.feed.sample.ui.common.mvp.MvpView

interface MainContract {

    interface View : MvpView {

    }

    interface Presenter {

        fun saveFilterSelection(filter: String, checked: Boolean)
    }
}
