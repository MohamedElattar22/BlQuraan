package com.iamelattar.blquraan.features.quraan.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Juz(
    @SerialName("number")
    val number: Int,
    @SerialName("name")
    val name: String,
)