package com.route.e_commercec19_mobiletrack.gsat.data.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorModel(
    @SerialName("message")
    val message: String? = null
)
