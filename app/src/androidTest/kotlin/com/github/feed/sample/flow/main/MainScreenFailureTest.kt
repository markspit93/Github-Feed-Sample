package com.github.feed.sample.flow.main

import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import com.github.feed.sample.BaseInstrumentationTest
import com.github.feed.sample.R
import com.github.feed.sample.data.repository.datasource.event.remote.RemoteEventDataSourceBehaviour
import com.github.feed.sample.ui.main.MainActivity
import com.github.feed.sample.util.toastIsShown
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith

@SmallTest
@RunWith(AndroidJUnit4::class)
class MainScreenFailureTest : BaseInstrumentationTest<MainActivity>(MainActivity::class.java) {

    companion object {
        @JvmStatic
        @BeforeClass
        fun setupClass() {
            RemoteEventDataSourceBehaviour.eventsConfig = RemoteEventDataSourceBehaviour.EventConfig.RATE_LIMIT_EXCEEDED
        }
    }

    @Test
    fun showLimiExceededError() {
        // Arrange

        // Act

        // Assert
        toastIsShown(testRule.activity, R.string.error_rate_limit)
    }
}
