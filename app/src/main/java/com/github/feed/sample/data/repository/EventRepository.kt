package com.github.feed.sample.data.repository

import com.github.feed.sample.data.repository.datasource.event.EventDataSource
import com.github.feed.sample.data.repository.datasource.event.remote.RemoteEventDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventRepository @Inject constructor(private val remoteEventDataSource: RemoteEventDataSource) : EventDataSource {

    override fun getEvents() = remoteEventDataSource.getEvents()
}
