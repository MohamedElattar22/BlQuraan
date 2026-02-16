package com.iamelattar.blquraan.utils

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

fun Context.hasPermissions(vararg permissions: String): Boolean {
    return permissions.all { permission ->
        ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
    }
}

fun Context.hasPermission(permission: String): Boolean {
    return ContextCompat.checkSelfPermission(
        this,
        permission
    ) == PackageManager.PERMISSION_GRANTED
}

fun Context.hasPermission(permission: Permission): Boolean {
    return ContextCompat.checkSelfPermission(
        this,
        permission.value
    ) == PackageManager.PERMISSION_GRANTED
}