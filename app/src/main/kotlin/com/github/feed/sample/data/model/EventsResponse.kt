package com.github.feed.sample.data.model

sealed class EventsResponse {

    data class Success(val events: List<Event>) : EventsResponse()

    // 403 error
    object RateLimitExceeded : EventsResponse()
}
