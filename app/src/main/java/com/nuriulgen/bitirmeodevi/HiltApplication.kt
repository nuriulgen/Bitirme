package com.nuriulgen.bitirmeodevi

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Hilt is a dependency injection library
 */
@HiltAndroidApp
class HiltApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}