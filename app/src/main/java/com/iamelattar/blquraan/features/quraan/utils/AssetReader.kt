package com.iamelattar.blquraan.features.quraan.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.json.Json
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AssetReader @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun readAssetFile(fileName: String): String =
        context.assets.open(fileName).bufferedReader().use { it.readText() }
}

object JsonHelper {
    val instance: Json = Json { ignoreUnknownKeys = true }
}