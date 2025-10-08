package com.iamelattar.blquraan.features.quraan.domain.repositories

import com.iamelattar.blquraan.features.quraan.domain.entities.Juz

interface JuzRepository {
    suspend fun getAllJuzs(): Result<List<Juz>>
}