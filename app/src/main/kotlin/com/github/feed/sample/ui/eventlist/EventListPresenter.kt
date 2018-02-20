package com.github.feed.sample.ui.eventlist

import com.github.feed.sample.data.model.EventsResponse.RateLimitExceeded
import com.github.feed.sample.data.model.EventsResponse.Success
import com.github.feed.sample.di.scopes.PerFragment
import com.github.feed.sample.ui.common.mvp.MvpPresenter
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

@PerFragment
class EventListPresenter @Inject constructor() : MvpPresenter<EventListContract.View, EventViewModel>(), EventListContract.Presenter {

    override fun onViewActive() {
        val subscriber = getViewModel().getEvents().subscribeBy(
            onNext = {
                when (it) {
                    is Success -> view?.showEvents(it.events)
                    is RateLimitExceeded -> view?.showLimitErrorMessage()
                }
            },
            onError = {
                view?.showGenericError()
            }
        )

        addObservables(subscriber)
    }
}
