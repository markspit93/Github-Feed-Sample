package com.github.feed.sample.ui.eventlist

import com.github.feed.sample.data.model.EventsResponse
import com.github.feed.sample.data.model.EventsResponse.RateLimitExceeded
import com.github.feed.sample.data.model.EventsResponse.Success
import com.github.feed.sample.di.scopes.PerFragment
import com.github.feed.sample.ui.common.mvp.MvpPresenter
import io.reactivex.subscribers.DisposableSubscriber
import javax.inject.Inject

@PerFragment
class EventListPresenter @Inject constructor() : MvpPresenter<EventListContract.View, EventViewModel>(), EventListContract.Presenter {

    override fun onActive() {
        val subscriber = object : DisposableSubscriber<EventsResponse>() {
            override fun onNext(e: EventsResponse) {
                when (e) {
                    is Success -> view?.showEvents(e.events)
                    is RateLimitExceeded -> view?.showLimitErrorMessage()
                }
            }

            override fun onError(t: Throwable?) {
                view?.showGenericError()
            }

            override fun onComplete() {}
        }

        getViewModel().getEvents().subscribe(subscriber)
        addObservables(subscriber)
    }
}
