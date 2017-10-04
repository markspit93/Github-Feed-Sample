package com.github.feed.sample.di

import com.github.feed.sample.data.api.ServiceGenerator
import com.github.feed.sample.data.repository.datasource.event.remote.EventService
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule

@Module(includes = arrayOf(AndroidInjectionModule::class))
class AppModule {

    @Provides
    fun provideEventService(serviceGenerator: ServiceGenerator): EventService = serviceGenerator.create(EventService.ENDPOINT, EventService::class.java)
}
