package com.iamelattar.blquraan.features.quraan.data

import com.iamelattar.blquraan.features.quraan.domain.Juz
import com.iamelattar.blquraan.features.quraan.domain.JuzRepository
import com.iamelattar.blquraan.features.quraan.utils.AssetReader
import kotlinx.serialization.json.Json
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JuzRepositoryImpl @Inject constructor(
    private val assetReader: AssetReader
) : JuzRepository {
    override suspend fun getAllJuzs(): Result<List<Juz>> = runCatching {
        val json = assetReader.readAssetFile("quran_juz.json")
        Json.decodeFromString<List<Juz>>(json)
    }
}