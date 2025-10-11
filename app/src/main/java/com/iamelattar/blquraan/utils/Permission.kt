package com.iamelattar.blquraan.utils

import android.Manifest
import android.os.Build
import androidx.annotation.RequiresApi

enum class Permission(
    val value: String,
) {
    FINE_LOCATION(
        value = Manifest.permission.ACCESS_FINE_LOCATION,
    ),
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    POST_NOTIFICATION(
        value = Manifest.permission.POST_NOTIFICATIONS,
    )
}