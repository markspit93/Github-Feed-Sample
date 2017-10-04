package com.github.feed.sample.flow.main

import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import com.github.feed.sample.BaseInstrumentationTest
import com.github.feed.sample.R
import com.github.feed.sample.data.repository.datasource.event.remote.RemoteEventDataSourceBehaviour
import com.github.feed.sample.data.repository.datasource.event.remote.RemoteEventDataSourceBehaviour.EventConfig.SUCCESSFUL
import com.github.feed.sample.ui.main.MainActivity
import com.github.feed.sample.util.clickView
import com.github.feed.sample.util.doesNotExist
import com.github.feed.sample.util.viewIsVisible
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith

@SmallTest
@RunWith(AndroidJUnit4::class)
class MainScreenSuccessfulTest : BaseInstrumentationTest<MainActivity>(MainActivity::class.java) {

    companion object {
        @JvmStatic
        @BeforeClass
        fun setupClass() {
            RemoteEventDataSourceBehaviour.eventsConfig = SUCCESSFUL
        }
    }

    @Test
    fun loadEvents() {
        // Arrange

        // Act

        // Assert
        viewIsVisible(R.id.eventRecyclerView)
    }

    @Test
    fun filterEvents() {
        // Arrange

        // Act
        clickView(R.id.menu_item_filter)
        clickView(R.id.action_filter_create)

        // Assert
        doesNotExist(R.id.eventRecyclerView)
    }
}
