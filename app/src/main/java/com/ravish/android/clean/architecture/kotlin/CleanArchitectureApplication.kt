package com.ravish.android.clean.architecture.kotlin

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CleanArchitectureApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}