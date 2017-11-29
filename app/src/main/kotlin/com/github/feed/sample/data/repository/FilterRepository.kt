package com.github.feed.sample.data.repository

import com.github.feed.sample.data.model.Filter
import com.github.feed.sample.data.repository.datasource.filter.FilterDataSource
import com.github.feed.sample.data.repository.datasource.filter.local.LocalFilterDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilterRepository @Inject constructor(private val localFilterDataSource: LocalFilterDataSource) : FilterDataSource {

    override fun getFilters(): List<Filter> = localFilterDataSource.getFilters()

    override fun saveFilter(filter: Filter) = localFilterDataSource.saveFilter(filter)
}
