package com.iamelattar.blquraan.features.quraan.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.iamelattar.blquraan.features.quraan.domain.Juz
import com.iamelattar.blquraan.features.quraan.domain.JuzRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JuzRepoImpl @Inject constructor(
    private val context: Context
) : JuzRepo {
    override suspend fun getAllJuzs(): Result<List<Juz>> {
        return try {
            val json =
                context.assets.open("quran_juz.json").bufferedReader().use {
                    it.readText()
                }
            val listType = object : TypeToken<List<Juz>>() {}.type
            val juz: List<Juz> = Gson().fromJson(json, listType)
            Result.success(juz)

        } catch (
            e: Exception
        ) {
            Result.failure(e)
        }

    }

}