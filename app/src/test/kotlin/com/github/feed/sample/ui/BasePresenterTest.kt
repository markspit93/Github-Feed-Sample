package com.github.feed.sample.ui

import android.arch.lifecycle.ViewModel
import com.github.feed.sample.ui.common.mvp.MvpPresenter
import com.github.feed.sample.ui.common.mvp.MvpView
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
abstract class BasePresenterTest<VIEW : MvpView, out PRESENTER : MvpPresenter<VIEW, VIEWMODEL>, VIEWMODEL : ViewModel> {

    private lateinit var presenter: PRESENTER
    abstract var view: VIEW

    @Before
    fun setUp() {
        presenter = createPresenter()
    }

    protected fun setViewModel(viewModel: VIEWMODEL) {
        presenter.setViewModel(viewModel)

        @Suppress("UNCHECKED_CAST")
        presenter.attachView(view)
    }

    abstract fun createPresenter(): PRESENTER
}
