package com.github.feed.sample.ui.main

import com.github.feed.sample.ui.common.mvp.MvpPresenter
import javax.inject.Inject

class MainPresenter @Inject constructor() : MvpPresenter<MainContract.View, MainViewModel>(), MainContract.Presenter {

    override fun loadFilterSelections() {
        getViewModel().filterList.forEach {
            view?.selectFilter(it.tag, it.checked)
        }
    }

    override fun saveFilterSelection(tag: String, checked: Boolean) {
        getViewModel().saveFilter(tag, checked)
    }
}
