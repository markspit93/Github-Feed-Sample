package com.github.feed.sample.data.api

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.github.feed.sample.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ServiceGenerator @Inject constructor() {

    private val builder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

    private lateinit var retrofit: Retrofit

    fun <T : Any> create(endpoint: String, serviceClass: Class<T>): T {
        val httpClient = OkHttpClient.Builder()
        httpClient.readTimeout(20, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG_MODE) {
            httpClient.addNetworkInterceptor(StethoInterceptor())
        }

        builder.baseUrl(endpoint).client(httpClient.build())
        retrofit = builder.build()

        return retrofit.create(serviceClass)
    }
}
