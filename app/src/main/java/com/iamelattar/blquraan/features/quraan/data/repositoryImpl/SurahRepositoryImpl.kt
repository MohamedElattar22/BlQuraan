package com.iamelattar.blquraan.features.quraan.data.repositoryImpl

import com.iamelattar.blquraan.features.quraan.domain.entities.Surah
import com.iamelattar.blquraan.features.quraan.domain.repositories.SurahRepository
import com.iamelattar.blquraan.features.quraan.utils.AssetManager
import com.iamelattar.blquraan.features.quraan.utils.JsonHelper
import com.iamelattar.blquraan.utils.Constants
import kotlinx.serialization.builtins.ListSerializer
import javax.inject.Inject

class SurahRepositoryImpl @Inject constructor(
    private val assetManager: AssetManager
) : SurahRepository {
    override suspend fun getAllSurahes(): Result<List<Surah>> =
        assetManager.readAssetFile(Constants.SURAH_JSON).mapCatching { json ->
            JsonHelper.instance.decodeFromString(ListSerializer(Surah.serializer()), json)
        }
}