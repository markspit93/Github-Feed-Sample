package com.github.feed.sample.ui.main

import com.github.feed.sample.data.model.Filter
import com.github.feed.sample.data.repository.FilterRepository
import com.github.feed.sample.di.scopes.PerActivity
import com.github.feed.sample.ext.lazyAndroid
import com.github.feed.sample.ui.common.mvp.MvpPresenter
import com.github.feed.sample.ui.common.mvp.NoViewModel
import javax.inject.Inject

@PerActivity
class MainPresenter @Inject constructor(private val filterRepository: FilterRepository) : MvpPresenter<MainContract.View, NoViewModel>(), MainContract.Presenter {

    private val filterList: MutableList<Filter> by lazyAndroid { filterRepository.getFilters().toMutableList() }

    override fun loadFilterSelections() {
        filterList.forEach {
            view?.selectFilter(it.tag, it.checked)
        }
    }

    override fun saveFilterSelection(tag: String, checked: Boolean) {
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
