package com.github.feed.sample.ui.eventlist

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.feed.sample.R
import com.github.feed.sample.data.model.Event
import com.github.feed.sample.di.viewmodel.ViewModelFactory
import com.github.feed.sample.ext.*
import com.github.feed.sample.ui.common.mvp.MvpFragment
import kotlinx.android.synthetic.main.fragment_event_list.*
import org.jetbrains.anko.support.v4.toast

class EventListFragment : MvpFragment<EventListContract.View, EventListPresenter, EventViewModel>(), EventListContract.View {

    private val adapter: EventListAdapter by lazyAndroid { EventListAdapter(eventClick) }
    lateinit var eventClick: (Event) -> Unit

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_event_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (context!!.hasInternetConnection()) {
            recyclerView.adapter = adapter
            recyclerView.setHasFixedSize(true)
        } else {
            txtLoading.gone()
            progressBar.gone()
            txtNoInternet.visible()
        }
    }

    override fun getViewModel(viewModelFactory: ViewModelFactory): EventViewModel {
        return ViewModelProviders.of(this, viewModelFactory).get()
    }

    override fun showEvents(events: List<Event>) {
        events.forEach { adapter.addEvent(it) }

        if (txtLoading.isVisible()) {
            recyclerView.scheduleLayoutAnimation()
            txtLoading.goneWithAnimation()
            progressBar.goneWithAnimation()
        }
    }

    override fun showLimitErrorMessage() {
        toast(R.string.error_rate_limit)
    }

    override fun showGenericError() {
        toast(R.string.error_loading_events)
    }

    fun filterEventType(type: String) {
        adapter.filterType(type)
    }

    fun unfilterEventType(type: String) {
        adapter.unfilterType(type)
        recyclerView.apply { post { smoothScrollToPosition(0) } }
    }
}
