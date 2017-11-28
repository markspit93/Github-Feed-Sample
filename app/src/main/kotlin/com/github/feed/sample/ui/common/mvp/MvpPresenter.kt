package com.github.feed.sample.ui.common.mvp

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class MvpPresenter<VIEW : MvpView, VIEWMODEL : ViewModel> {

    protected var view: VIEW? = null
    private var compositeDisposable = CompositeDisposable()

    private lateinit var viewModel: VIEWMODEL

    fun getViewModel(): VIEWMODEL {
        if (!this::viewModel.isInitialized) {
            throw UninitializedPropertyAccessException("The presenter's ViewModel was not initialized. Make sure to call presenter.setViewModel() from the View first.")
        }

        return viewModel
    }

    fun setViewModel(viewModel: VIEWMODEL) {
        this.viewModel = viewModel
    }

    fun attachView(view: VIEW) {
        this.view = view
        onActive()
    }

    fun detachView() {
        view = null
        compositeDisposable.clear()
        onInactive()
    }

    fun addObservables(vararg disposable: Disposable) {
        disposable.forEach { compositeDisposable.add(it) }
    }

    open fun onActive() {
        // override if necessary
    }

    open fun onInactive() {
        // override if necessary
    }
}
