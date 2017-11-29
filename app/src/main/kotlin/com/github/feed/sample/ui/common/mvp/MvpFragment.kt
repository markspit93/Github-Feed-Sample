package com.github.feed.sample.ui.common.mvp

import android.arch.lifecycle.ViewModel
import com.github.feed.sample.ui.common.BaseFragment
import javax.inject.Inject

abstract class MvpFragment<VIEW : MvpView, PRESENTER : MvpPresenter<VIEW, VIEWMODEL>, VIEWMODEL: ViewModel> : BaseFragment(), MvpView {

    @Inject lateinit var presenter: PRESENTER

    override fun onStart() {
        super.onStart()
        @Suppress("UNCHECKED_CAST")
        presenter.attachView(this as VIEW)
    }

    override fun onStop() {
        presenter.detachView()
        super.onStop()
    }
}
