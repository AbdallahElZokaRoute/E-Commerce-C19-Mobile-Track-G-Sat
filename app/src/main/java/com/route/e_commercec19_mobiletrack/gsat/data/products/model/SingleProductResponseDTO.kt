package com.route.e_commercec19_mobiletrack.gsat.data.products.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class SingleProductResponseDTO(

    @SerialName("data")
    val data: SingleProductItemDTO? = null
)

@Serializable
data class Brand(

    @SerialName("image")
    val image: String? = null,

    @SerialName("name")
    val name: String? = null,

    @SerialName("_id")
    val id: String? = null,

    @SerialName("slug")
    val slug: String? = null
)

@Serializable
data class SingleProductItemDTO(

    @SerialName("sold")
    val sold: Int? = null,

    @SerialName("images")
    val images: List<String?>? = null,

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

    @SerialName("reviews")
    val reviews: List<ReviewsItem?>? = null,

    @SerialName("price")
    val price: Int? = null,

    @SerialName("__v")
    val v: Int? = null,

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
    val updatedAt: String? = null
)

@Serializable
data class Category(

    @SerialName("image")
    val image: String? = null,

    @SerialName("name")
    val name: String? = null,

    @SerialName("_id")
    val id: String? = null,

    @SerialName("slug")
    val slug: String? = null
)

@Serializable
data class ReviewsItem(

    @SerialName("createdAt")
    val createdAt: String? = null,

    @SerialName("product")
    val product: String? = null,

    @SerialName("review")
    val review: String? = null,

    @SerialName("__v")
    val v: Int? = null,

    @SerialName("rating")
    val rating: Int? = null,

    @SerialName("_id")
    val id: String? = null,

    @SerialName("user")
    val user: User? = null,

    @SerialName("updatedAt")
    val updatedAt: String? = null
)

@Serializable
data class SubcategoryItem(

    @SerialName("name")
    val name: String? = null,

    @SerialName("_id")
    val id: String? = null,

    @SerialName("category")
    val category: String? = null,

    @SerialName("slug")
    val slug: String? = null
)

@Serializable
data class User(

    @SerialName("name")
    val name: String? = null,

    @SerialName("_id")
    val id: String? = null
)
