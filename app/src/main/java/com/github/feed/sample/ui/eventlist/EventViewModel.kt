package com.github.feed.sample.ui.eventlist

import android.arch.lifecycle.ViewModel
import com.github.feed.sample.data.*
import com.github.feed.sample.data.model.EventsResponse
import com.github.feed.sample.data.repository.EventRepository
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class EventViewModel @Inject constructor(private val eventRepository: EventRepository) : ViewModel() {

    companion object {
        private val allowedEvents = arrayOf(EVENT_CREATE, EVENT_DELETE, EVENT_FORK, EVENT_PULL_REQUEST, EVENT_PUSH, EVENT_WATCH)
    }

    private val cachedEvents: MutableList<EventsResponse> = mutableListOf()

    fun getEvents(): Flowable<EventsResponse> {
        val cachedEventsObservable = Flowable.fromArray(cachedEvents).flatMap { source -> Flowable.fromIterable(source) }

        return eventRepository
            .getEvents()
            .repeatWhen { observable -> observable.delay(1, TimeUnit.SECONDS) }
            .subscribeOn(Schedulers.io())
            .map { response ->
                when (response.code()) {
                    HttpURLConnection.HTTP_FORBIDDEN -> EventsResponse.RateLimitExceeded
                    else -> EventsResponse.Success(requireNotNull(response.body())
                        .filter { it.type in allowedEvents })
                        .apply { cachedEvents.add(this) }
                }
            }
            .toFlowable(BackpressureStrategy.BUFFER)
            .observeOn(AndroidSchedulers.mainThread())
            .startWith(cachedEventsObservable)
    }
}
