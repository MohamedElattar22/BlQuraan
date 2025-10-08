package com.iamelattar.blquraan.features.quraan.domain.usecases

import com.iamelattar.blquraan.features.quraan.domain.entities.Surah
import com.iamelattar.blquraan.features.quraan.domain.repositories.SurahRepository
import jakarta.inject.Inject

class GetAllSurahesUseCase@Inject constructor(
    private val surahRepository: SurahRepository
) {
    suspend operator fun invoke(): Result<List<Surah>> {
        return surahRepository.getAllSurahes()
    }
}