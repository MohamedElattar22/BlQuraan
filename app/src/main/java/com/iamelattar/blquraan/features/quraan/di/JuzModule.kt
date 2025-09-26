package com.iamelattar.blquraan.features.quraan.di

import com.iamelattar.blquraan.features.quraan.utils.AssetReader
import com.iamelattar.blquraan.features.quraan.data.JuzRepositoryImpl
import com.iamelattar.blquraan.features.quraan.domain.JuzRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object JuzModule {

    @Provides
    fun provideJuzRepository(
        assetReader: AssetReader
    ): JuzRepository = JuzRepositoryImpl(assetReader)

}