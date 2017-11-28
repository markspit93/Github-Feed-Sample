package com.github.feed.sample

import android.app.Activity
import android.app.Application
import android.os.StrictMode
import com.facebook.stetho.Stetho
import com.github.feed.sample.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        initDagger()
        initStetho()
//        initStrictMode()
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }

    private fun initDagger() {
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG_MODE) {
            Stetho.initialize(Stetho.newInitializerBuilder(this)
                    .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                    .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                    .build())
        }
    }

    private fun initStrictMode() {
        if (BuildConfig.DEBUG_MODE) {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build())

            StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build())
        }
    }
}
