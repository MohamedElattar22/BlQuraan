package com.iamelattar.blquraan.features.quraan.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Juz(
    val id: Int,
    @SerialName("name")
    val name: String,
)
