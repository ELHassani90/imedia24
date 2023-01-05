package com.imedia.Store.Dtos

import java.math.BigDecimal
import java.time.ZonedDateTime

data class ProductDto(
    val sku: String,
    val name: String,
    val description: String? = null,
    val price: Double,
    val createdAt: ZonedDateTime,
    val updatedAt: ZonedDateTime
)
