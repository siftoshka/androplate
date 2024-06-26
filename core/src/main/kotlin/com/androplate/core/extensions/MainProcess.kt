package com.androplate.core.extensions

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.os.Build
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

fun Context.isMainProcess(): Boolean {
    return (this.applicationContext.packageName == (getProcessString() ?: true))
}

@SuppressLint("DiscouragedPrivateApi", "PrivateApi")
private fun getProcessString(): String? {
    return if (Build.VERSION.SDK_INT >= 28) Application.getProcessName() else try {
        @SuppressLint("PrivateApi") val activityThread = Class.forName("android.app.ActivityThread")
        val methodName = "currentProcessName"
        val getProcessName: Method = activityThread.getDeclaredMethod(methodName)
        return getProcessName.invoke(null) as String
    } catch (e: ClassNotFoundException) {
        null
    } catch (e: NoSuchMethodException) {
        null
    } catch (e: IllegalAccessException) {
        null
    } catch (e: InvocationTargetException) {
        null
    }
}