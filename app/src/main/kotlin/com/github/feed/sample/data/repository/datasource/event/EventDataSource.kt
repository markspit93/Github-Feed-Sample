package com.github.feed.sample.data.repository.datasource.event

import com.github.feed.sample.data.model.Event
import io.reactivex.Observable
import retrofit2.Response

interface EventDataSource {

    fun getEvents(): Observable<Response<List<Event>>>
}
