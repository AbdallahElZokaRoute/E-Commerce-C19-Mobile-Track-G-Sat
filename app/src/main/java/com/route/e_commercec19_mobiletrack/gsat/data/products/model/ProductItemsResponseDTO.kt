package com.route.e_commercec19_mobiletrack.gsat.data.products.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class ProductItemsResponseDTO(
    @SerialName("data")
    val data: List<ProductItemDTO>? = null,
)

@Serializable
data class ProductItemDTO(

    @SerialName("sold")
    val sold: Int? = null,

    @SerialName("images")
    val images: List<String>? = null,

    @SerialName("quantity")
    val quantity: Int? = null,


    @SerialName("imageCover")
    val imageCover: String? = null,

    @SerialName("description")
    val description: String? = null,

    @SerialName("title")
    val title: String? = null,

    @SerialName("ratingsQuantity")
    val ratingsQuantity: Int? = null,

    @SerialName("ratingsAverage")
    val ratingsAverage: Double? = null,

    @SerialName("createdAt")
    val createdAt: String? = null,

    @SerialName("price")
    val price: Int? = null,

    @SerialName("_id")
    val id: String? = null,

    @SerialName("subcategory")
    val subcategory: List<SubcategoryItem?>? = null,

    @SerialName("category")
    val category: Category? = null,

    @SerialName("brand")
    val brand: Brand? = null,

    @SerialName("slug")
    val slug: String? = null,

    @SerialName("updatedAt")
    val updatedAt: String? = null,

    @SerialName("priceAfterDiscount")
    val priceAfterDiscount: Int? = null
)
