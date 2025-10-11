package com.iamelattar.blquraan.features.quraan.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AssetReader @Inject constructor(
    @ApplicationContext private val context: Context
) : AssetManager {
    override suspend fun readAssetFile(fileName: String): Result<String> =
        withContext(Dispatchers.IO) {
            runCatching {
                context.assets.open(fileName).bufferedReader().use { it.readText() }
            }
        }
}
object JsonHelper {
    val instance: Json = Json { ignoreUnknownKeys = true }
}