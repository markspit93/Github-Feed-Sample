package com.github.feed.sample.di.android

import com.github.feed.sample.di.scopes.PerFragment
import com.github.feed.sample.ui.eventlist.EventListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentProvider {

    @PerFragment
    @ContributesAndroidInjector
    abstract fun provideEventListFragmentInjector(): EventListFragment
}
