package com.github.feed.sample.data.repository.datasource.event.remote

import com.github.feed.sample.BuildConfig
import com.github.feed.sample.data.model.Event
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface EventService {

    companion object {
        const val ENDPOINT = BuildConfig.GITHUB_API_ENDPOINT
    }

    @GET("events")
    @Headers("Accept: application/vnd.github.v3+json", "Authorization: Bearer ${BuildConfig.GITHUB_API_TOKEN}")
    fun getEvents(): Observable<Response<List<Event>>>
}
