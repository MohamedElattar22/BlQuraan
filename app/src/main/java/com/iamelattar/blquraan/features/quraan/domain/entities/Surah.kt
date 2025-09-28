package com.iamelattar.blquraan.features.quraan.domain.entities

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
)