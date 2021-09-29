package com.github.feed.sample.data.repository.datasource.event.remote

import com.github.feed.sample.data.repository.datasource.event.EventDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteEventDataSource @Inject constructor(private val service: EventService) : EventDataSource {

    override fun getEvents() = RemoteEventDataSourceBehaviour.runGetEventsConfig()
}
