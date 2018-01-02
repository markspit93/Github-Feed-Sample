package com.github.feed.sample.ui.main

import android.arch.lifecycle.ViewModel
import com.github.feed.sample.data.model.Filter
import com.github.feed.sample.data.repository.FilterRepository
import com.github.feed.sample.ext.lazyAndroid
import javax.inject.Inject

class MainViewModel @Inject constructor(private val filterRepository: FilterRepository) : ViewModel() {

    val filterList: MutableList<Filter> by lazyAndroid { filterRepository.getFilters().toMutableList() }

    fun saveFilter(tag: String, checked: Boolean) {
        var filter: Filter? = filterList.find { it.tag == tag }

        if (filter == null) {
            filter = Filter(tag = tag, checked = checked)
            filterList.add(filter)
            filterRepository.saveFilter(filter)
        } else {
            filter.checked = checked
            filterRepository.saveFilter(filter)
        }
    }
}
