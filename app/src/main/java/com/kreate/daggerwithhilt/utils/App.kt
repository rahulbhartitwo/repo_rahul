package com.kreate.daggerwithhilt.utils

import android.app.Application
import com.facebook.stetho.Stetho
import com.kreate.daggerwithhilt.BuildConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this)
    }
}