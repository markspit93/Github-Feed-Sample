package com.github.feed.sample.di.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.github.feed.sample.ui.eventlist.EventViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(EventViewModel::class)
    abstract fun bindEventViewModel(eventViewModel: EventViewModel) : ViewModel

    @Binds
    abstract fun bindViewModelFactory( factory: ViewModelFactory) : ViewModelProvider.Factory
}
