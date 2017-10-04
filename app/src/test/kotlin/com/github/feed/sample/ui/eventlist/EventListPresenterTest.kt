package com.github.feed.sample.ui.eventlist

import com.github.feed.sample.ui.BasePresenterTest
import com.github.feed.sample.ui.eventlist.EventViewModel.Config.*
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import org.junit.Test
import org.mockito.Mockito.verify

class EventListPresenterTest : BasePresenterTest<EventListContract.View, EventListPresenter, EventViewModel>() {

    override var view: EventListContract.View = mock()

    override fun createPresenter() = EventListPresenter()

    @Test
    fun getEvents_successful() {
        // Arrange
        setViewModel(EventViewModel(SUCCESSFUL))

        // Act

        // Assert
        verify(view).showEvents(any())
    }

    @Test
    fun getEvents_failureLimitExceeded() {
        // Arrange
        setViewModel(EventViewModel(RATE_LIMIT_EXCEEDED))

        // Act

        // Assert
        verify(view).showLimitErrorMessage()
    }

    @Test(expected = RuntimeException::class)
    fun getEvents_failureGenericError() {
        // Arrange
        setViewModel(EventViewModel(GENERIC_ERROR))

        // Act

        // Assert
        verify(view).showGenericError()
    }
}
