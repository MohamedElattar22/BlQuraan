package com.iamelattar.blquraan.features.quraan.domain.repositories

import com.iamelattar.blquraan.features.quraan.domain.entities.Surah

interface SurahRepository {
    suspend fun getAllSurahes(): Result<List<Surah>>
}