package com.github.feed.sample.di.android

import com.github.feed.sample.di.scopes.PerActivity
import com.github.feed.sample.ui.details.DetailsActivity
import com.github.feed.sample.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityProvider {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun provideDetailsActivityInjector(): DetailsActivity

    @PerActivity
    @ContributesAndroidInjector
    abstract fun provideMainActivityInjector(): MainActivity
}
