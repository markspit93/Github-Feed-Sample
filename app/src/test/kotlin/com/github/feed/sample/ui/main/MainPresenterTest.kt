package com.github.feed.sample.ui.main

import com.github.feed.sample.data.model.Filter
import com.github.feed.sample.data.repository.FilterRepository
import com.github.feed.sample.data.repository.datasource.filter.local.LocalFilterDataSource
import com.github.feed.sample.ui.BasePresenterTest
import com.github.feed.sample.ui.common.mvp.NoViewModel
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import io.objectbox.kotlin.boxFor
import org.junit.Test
import org.mockito.Mockito.verify

class MainPresenterTest : BasePresenterTest<MainContract.View, MainPresenter, NoViewModel>() {

    override var view: MainContract.View = mock()

    override fun createPresenter() = MainPresenter(FilterRepository(LocalFilterDataSource(boxStore)))

    @Test
    fun loadFilterSelections_Successful() {
        // Arrange
        setViewModel(NoViewModel())

        val filterBox = boxStore.boxFor(Filter::class)
        filterBox.put(Filter(tag = "tag", checked = true))

        // Act
        presenter.loadFilterSelections()

        // Assert
        verify(view).selectFilter(any(), any())
    }
}
