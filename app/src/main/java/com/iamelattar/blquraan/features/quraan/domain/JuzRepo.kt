package com.iamelattar.blquraan.features.quraan.domain

interface JuzRepo {
    suspend fun getAllJuzs(): Result<List<Juz>>
}