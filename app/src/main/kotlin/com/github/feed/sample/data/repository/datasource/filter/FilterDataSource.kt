package com.github.feed.sample.data.repository.datasource.filter

import com.github.feed.sample.data.model.Filter

interface FilterDataSource {

    fun getFilters(): List<Filter>

    fun saveFilter(filter: Filter): Long
}
