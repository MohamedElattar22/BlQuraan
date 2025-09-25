package com.iamelattar.blquraan.features.quraan.domain

interface SurahRepo {
    // add abstraction
    suspend fun getAllSurahes(): Result<List<Surah>>


}