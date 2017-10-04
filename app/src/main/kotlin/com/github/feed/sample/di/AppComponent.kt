package com.github.feed.sample.di

import android.app.Application
import com.github.feed.sample.App
import com.github.feed.sample.di.android.ActivityProvider
import com.github.feed.sample.di.android.FragmentProvider
import com.github.feed.sample.di.viewmodel.ViewModelsModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityProvider::class,
        FragmentProvider::class,
        ViewModelsModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)
}
