package com.route.e_commercec19_mobiletrack.gsat.data.categories.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class CategoriesResponse(

    @SerialName("metadata")
    val metadata: CategoriesMetadata? = null,

    @SerialName("data")
    val data: List<CategoryDTO>? = null,

    @SerialName("message")
    val errorMessage: String? = null,

    @SerialName("results")
    val results: Int? = null
)

@Serializable
data class CategoriesMetadata(

    @SerialName("numberOfPages")
    val numberOfPages: Int? = null,

    @SerialName("limit")
    val limit: Int? = null,

    @SerialName("currentPage")
    val currentPage: Int? = null
)

@Serializable
data class CategoryDTO(

    @SerialName("image")
    val image: String? = null,

    @SerialName("createdAt")
    val createdAt: String? = null,

    @SerialName("name")
    val name: String? = null,

    @SerialName("_id")
    val id: String? = null,

    @SerialName("slug")
    val slug: String? = null,

    @SerialName("updatedAt")
    val updatedAt: String? = null
)
