package com.iamelattar.blquraan.features.quraan.di

import android.content.Context
import com.iamelattar.blquraan.features.quraan.data.JuzRepoImpl
import com.iamelattar.blquraan.features.quraan.domain.JuzRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object JuzModule {

    @Provides
    fun provideJuzRepository(
        @ApplicationContext context: Context
    ): JuzRepo = JuzRepoImpl(context)

}