package com.iamelattar.blquraan.features.quraan.di

import android.content.Context
import com.iamelattar.blquraan.features.quraan.data.SurahRepoImpl
import com.iamelattar.blquraan.features.quraan.domain.SurahRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object SurahModule {

    @Provides
    fun provideSurahRepository(
        @ApplicationContext context: Context

    ): SurahRepo = SurahRepoImpl(context)

}


