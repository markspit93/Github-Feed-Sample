package com.github.feed.sample.ui.common.mvp

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class MvpPresenter<VIEW : MvpView, VIEWMODEL : ViewModel> {

    protected var view: VIEW? = null
    private var compositeDisposable = CompositeDisposable()

    lateinit var viewModel: VIEWMODEL

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
