package com.route.e_commercec19_mobiletrack.gsat.data.products.mapper

import com.route.e_commercec19_mobiletrack.gsat.data.products.model.ProductItemDTO
import com.route.e_commercec19_mobiletrack.gsat.data.products.model.SingleProductItemDTO
import com.route.e_commercec19_mobiletrack.gsat.domain.products.entity.ProductEntity
import com.route.e_commercec19_mobiletrack.gsat.domain.products.entity.SingleProductEntity

fun ProductItemDTO.toDomain(): ProductEntity = ProductEntity(
    sold = sold,
    images = images,
    quantity = quantity,
    imageCover = imageCover,
    description = description,
    title = title,
    ratingsQuantity = ratingsQuantity,
    ratingsAverage = ratingsAverage,
    createdAt = createdAt,
    price = price,
    id = id,
    slug = slug,
    updatedAt = updatedAt,
    priceAfterDiscount = priceAfterDiscount
)

fun SingleProductItemDTO.toDomain(): SingleProductEntity = SingleProductEntity(
    sold = sold, images = images, quantity = quantity, imageCover = imageCover,
    description = description, title = title, ratingsQuantity = ratingsQuantity,
    ratingsAverage = ratingsAverage, createdAt = createdAt, updatedAt = updatedAt,
    slug = slug
)