package com.github.feed.sample.di.android

import com.github.feed.sample.ui.details.DetailsActivity
import com.github.feed.sample.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityProvider {

    @ContributesAndroidInjector
    abstract fun provideDetailsActivityInjector(): DetailsActivity

    @ContributesAndroidInjector
    abstract fun provideMainActivityInjector(): MainActivity
}
