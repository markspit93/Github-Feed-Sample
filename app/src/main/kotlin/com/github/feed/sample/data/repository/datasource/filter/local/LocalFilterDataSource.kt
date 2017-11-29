package com.github.feed.sample.data.repository.datasource.filter.local

import com.github.feed.sample.data.model.Filter
import com.github.feed.sample.data.repository.datasource.filter.FilterDataSource
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalFilterDataSource @Inject constructor(private val boxStore: BoxStore) : FilterDataSource {

    private val filterBox = boxStore.boxFor(Filter::class)

    override fun getFilters(): List<Filter> = filterBox.all

    override fun saveFilter(filter: Filter) = filterBox.put(filter)
}
