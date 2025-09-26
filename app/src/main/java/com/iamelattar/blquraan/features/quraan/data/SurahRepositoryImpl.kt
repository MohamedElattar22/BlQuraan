package com.iamelattar.blquraan.features.quraan.data

import com.iamelattar.blquraan.features.quraan.domain.Surah
import com.iamelattar.blquraan.features.quraan.domain.SurahRepository
import com.iamelattar.blquraan.features.quraan.utils.AssetReader
import com.iamelattar.blquraan.features.quraan.utils.JsonHelper
import kotlinx.serialization.builtins.ListSerializer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SurahRepositoryImpl @Inject constructor(
    private val assetReader: AssetReader
) : SurahRepository {
    override suspend fun getAllSurahes(): Result<List<Surah>> = runCatching {
        val json = assetReader.readAssetFile("surahes_data.json")
        JsonHelper.instance.decodeFromString(ListSerializer(Surah.serializer()), json)
    }
}
