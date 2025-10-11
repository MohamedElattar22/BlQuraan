package com.iamelattar.blquraan.features.quraan.domain.usecases

import com.iamelattar.blquraan.features.quraan.domain.entities.Juz
import com.iamelattar.blquraan.features.quraan.domain.repositories.JuzRepository
import jakarta.inject.Inject

class GetAllJuzUseCase @Inject constructor(
    private val juzRepository: JuzRepository
) {
    suspend operator fun invoke(): Result<List<Juz>> {
        return juzRepository.getAllJuzs()
    }
}