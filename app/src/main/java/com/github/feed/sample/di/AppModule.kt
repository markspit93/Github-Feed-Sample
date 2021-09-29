package com.github.feed.sample.di

import android.app.Application
import com.github.feed.sample.data.api.ServiceGenerator
import com.github.feed.sample.data.model.MyObjectBox
import com.github.feed.sample.data.repository.datasource.event.remote.EventService
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import io.objectbox.BoxStore
import javax.inject.Singleton

@Module(includes = arrayOf(AndroidInjectionModule::class))
class AppModule(private val application: Application) {

    @Provides
    fun provideEventService(serviceGenerator: ServiceGenerator): EventService
            = serviceGenerator.create(EventService.ENDPOINT, EventService::class.java)

    @Provides
    @Singleton
    fun provideBoxStore(): BoxStore
            = MyObjectBox.builder().androidContext(application).build()
}
