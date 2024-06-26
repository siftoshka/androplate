package com.androplate.core.extensions

import android.annotation.SuppressLint
import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Environment
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import java.io.File

@SuppressLint("DiscouragedApi")
fun Context.fromStringToDrawable(resourceName: String): Int {
    return resources.getIdentifier(resourceName, "drawable", packageName)
}

fun Context.vibratePhone(pattern: LongArray = longArrayOf(0, 250, 500, 250, 500)) {
    val vibrator = ContextCompat.getSystemService(this, Vibrator::class.java)
    vibrator?.let {
        if (!vibrator.hasVibrator())
            return
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(
                VibrationEffect.createWaveform(pattern, VibrationEffect.DEFAULT_AMPLITUDE)
            )
        } else {
            @Suppress("DEPRECATION")
            vibrator.vibrate(pattern, -1)
        }
    }
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

@Suppress("DEPRECATION")
fun Context.isNetworkAvailable(): Boolean {
    val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val n = cm.activeNetwork
    if (n != null) {
        val nc = cm.getNetworkCapabilities(n)
        return nc?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ?: false
                || nc?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ?: false
                || nc?.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) ?: false
    }
    return false
}

fun Context.getBaseFolder(path: String): File {
    val sd: File = this.cacheDir
    val folder = File(sd, "/$path/")
    if (!folder.exists()) {
        if (!folder.mkdir()) {
            Log.e("getBaseFolder:", "Cannot create a directory!")
        } else {
            folder.mkdirs()
        }
    }
    return folder
}

fun Context.getFileDownloadPath(fileName: String): File {
    return File(
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
        fileName
    )
}

@SuppressLint("MissingPermission")
fun Context.createLocalNotification(
    notificationId: Int = (0..100).random(),
    title: String,
    context: String,
    icon: Int,
    priority: Int = NotificationCompat.PRIORITY_DEFAULT,
    tapAction: PendingIntent? = null,
    autoCancel: Boolean = true
) {
    val channelId = "GP"
    val notificationManagerCompat = NotificationManagerCompat.from(this)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        notificationManagerCompat.createNotificationChannel(
            NotificationChannel(
                channelId,
                "Azercell-MyCabinet",
                NotificationManager.IMPORTANCE_DEFAULT
            )
        )
    }

    val builder = NotificationCompat.Builder(this, channelId)
        .setContentTitle(title)
        .setContentText(context)
        .setSmallIcon(icon)
        .setPriority(priority)
        .setContentIntent(tapAction)
        .setAutoCancel(autoCancel)

    notificationManagerCompat.notify(notificationId, builder.build())
}