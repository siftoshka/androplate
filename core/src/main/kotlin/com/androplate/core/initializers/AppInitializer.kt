package com.androplate.core.initializers

import android.app.Application

interface AppInitializer {
    fun init(application: Application)
}