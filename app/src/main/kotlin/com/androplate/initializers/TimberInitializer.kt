package com.androplate.initializers

import android.app.Application
import com.androplate.BuildConfig
import com.androplate.core.initializers.AppInitializer
import timber.log.Timber
import javax.inject.Inject

class TimberInitializer @Inject constructor() : AppInitializer {

    override fun init(application: Application) {
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement) =
                    "${super.createStackElementTag(element)}:${element.lineNumber}"
            })
        }
    }
}
