package com.iamelattar.blquraan.features.quraan.domain

interface JuzRepository {
    suspend fun getAllJuzs(): Result<List<Juz>>
}