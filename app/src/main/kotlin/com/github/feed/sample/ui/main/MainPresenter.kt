package com.github.feed.sample.ui.main

import com.github.feed.sample.di.scopes.PerActivity
import com.github.feed.sample.ui.common.mvp.MvpPresenter
import com.github.feed.sample.ui.common.mvp.NoViewModel
import javax.inject.Inject

@PerActivity
class MainPresenter @Inject constructor() : MvpPresenter<MainContract.View, NoViewModel>(), MainContract.Presenter {

    override fun loadFilterSelections() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveFilterSelection(tag: String, checked: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
