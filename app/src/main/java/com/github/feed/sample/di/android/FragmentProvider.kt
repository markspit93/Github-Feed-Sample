package com.github.feed.sample.di.android

import com.github.feed.sample.ui.eventlist.EventListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentProvider {

    @ContributesAndroidInjector
    abstract fun provideEventListFragmentInjector(): EventListFragment
}
