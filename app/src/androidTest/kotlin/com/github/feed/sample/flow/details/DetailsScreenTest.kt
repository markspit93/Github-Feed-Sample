package com.github.feed.sample.flow.details

import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import com.github.feed.sample.BaseInstrumentationTest
import com.github.feed.sample.R
import com.github.feed.sample.data.repository.datasource.event.remote.RemoteEventDataSourceBehaviour
import com.github.feed.sample.ui.details.DetailsActivity
import com.github.feed.sample.ui.main.MainActivity
import com.github.feed.sample.util.clickView
import com.github.feed.sample.util.nextOpenActivityIs
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith

@SmallTest
@RunWith(AndroidJUnit4::class)
class DetailsScreenTest : BaseInstrumentationTest<MainActivity>(MainActivity::class.java) {

    companion object {
        @JvmStatic
        @BeforeClass
        fun setupClass() {
            RemoteEventDataSourceBehaviour.eventsConfig = RemoteEventDataSourceBehaviour.EventConfig.SUCCESSFUL
        }
    }

    @Test
    fun showEventDetails() {
        // Arrange

        // Act
        clickView(R.id.cardEvent)

        // Assert
        nextOpenActivityIs(DetailsActivity::class.java)
    }
}