package com.iamelattar.blquraan.features.quraan.domain

interface SurahRepository {
    // add abstraction
    suspend fun getAllSurahes(): Result<List<Surah>>


}