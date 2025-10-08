package com.iamelattar.blquraan.features.quraan.data.repositoryImpl

import com.iamelattar.blquraan.features.quraan.domain.entities.Juz
import com.iamelattar.blquraan.features.quraan.domain.repositories.JuzRepository
import com.iamelattar.blquraan.features.quraan.utils.AssetManager
import com.iamelattar.blquraan.features.quraan.utils.Constants
import com.iamelattar.blquraan.features.quraan.utils.JsonHelper
import javax.inject.Inject
import javax.inject.Singleton

class JuzRepositoryImpl @Inject constructor(
    private val assetManager: AssetManager
) : JuzRepository {
    override suspend fun getAllJuzs(): Result<List<Juz>> =
        assetManager.readAssetFile(Constants.JUZ_JSON).mapCatching { json ->
            JsonHelper.instance.decodeFromString<List<Juz>>(json)
        }
}