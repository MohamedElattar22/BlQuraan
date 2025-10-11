package com.iamelattar.blquraan.features.quraan.domain.entities

import com.iamelattar.blquraan.utils.Constants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Surah(
    @SerialName("id")
    val id: Int,
    @SerialName("arabic")
    val arabic: String,
    @SerialName("aya")
    val aya: Int,
    @SerialName("place")
    val place: String,
    @SerialName("startPage")
    val startPage: Int,
){
    val surahPlace : String = when(place){
        Constants.MAKKAH -> "مكية"
        Constants.MADINAH -> "مدنية"
        else -> ""
    }
}