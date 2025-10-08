package com.iamelattar.blquraan.features.quraan.utils

interface AssetManager {
    suspend fun readAssetFile(fileName: String): Result<String>
}