package com.iamelattar.blquraan.features.quraan.di

import com.iamelattar.blquraan.features.quraan.utils.AssetReader
import com.iamelattar.blquraan.features.quraan.data.repositoryImpl.SurahRepositoryImpl
import com.iamelattar.blquraan.features.quraan.domain.repositories.SurahRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SurahModule {
    @Provides
    fun provideSurahRepository(
        assetReader: AssetReader
    ): SurahRepository = SurahRepositoryImpl(assetReader)
}


