package com.kreate.daggerwithhilt.utils

import android.app.Activity
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import com.kreate.daggerwithhilt.BuildConfig


fun log(log: String, msg: String) {
    if (BuildConfig.DEBUG)
        Log.d(log, msg)
}


fun snackbar(message: String, activity: Activity = Activity()) {
    if (BuildConfig.DEBUG)
        Snackbar.make(
        activity.findViewById(android.R.id.content),
        message,
        Snackbar.LENGTH_LONG
    ).show()
}
