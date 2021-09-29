package com.github.feed.sample.ui.eventlist

import com.github.feed.sample.data.model.Event
import com.github.feed.sample.ui.common.mvp.MvpView

interface EventListContract {

    interface View : MvpView {

        fun showEvents(events: List<Event>)

        fun showLimitErrorMessage()

        fun showGenericError()
    }

    interface Presenter
}
