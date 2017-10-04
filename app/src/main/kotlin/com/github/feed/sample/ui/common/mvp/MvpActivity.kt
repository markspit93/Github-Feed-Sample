package com.github.feed.sample.ui.common.mvp

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import com.github.feed.sample.ui.common.BaseActivity
import javax.inject.Inject

abstract class MvpActivity<VIEW : MvpView, PRESENTER : MvpPresenter<VIEW, VIEWMODEL>, VIEWMODEL: ViewModel> : BaseActivity(), MvpView {

    @Inject lateinit var presenter: PRESENTER

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.viewModel = getViewModel()
    }

    override fun onStart() {
        super.onStart()
        @Suppress("UNCHECKED_CAST")
        presenter.attachView(this as VIEW)
    }

    override fun onStop() {
        presenter.detachView()
        super.onStop()
    }

    abstract fun getViewModel(): VIEWMODEL
}
