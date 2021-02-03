package com.ogunladetaiye

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class UduxApplication:Application() {

    override fun onCreate() {
        super.onCreate()
    }
}