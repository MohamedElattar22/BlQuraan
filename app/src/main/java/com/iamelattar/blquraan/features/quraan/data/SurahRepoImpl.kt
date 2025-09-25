package com.iamelattar.blquraan.features.quraan.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.iamelattar.blquraan.features.quraan.domain.Surah
import com.iamelattar.blquraan.features.quraan.domain.SurahRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SurahRepoImpl @Inject constructor(
    private val context: Context
) : SurahRepo {
    override suspend fun getAllSurahes(): Result<List<Surah>> {
        return try {
            val json =

                context.assets.open("surahes_data.json").bufferedReader().use {
                    it.readText()
                }
            val listType = object : TypeToken<List<Surah>>() {}.type
            val surahes: List<Surah> = Gson().fromJson(json, listType)
            Result.success(surahes)

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
