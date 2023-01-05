package com.imedia.Store.Services

import com.imedia.Store.Dtos.ProductDto
import com.imedia.Store.Models.Product
import org.springframework.stereotype.Component

@Component
public class ProductMapper: Mapper<ProductDto, Product> {
    override fun fromEntity(entity: Product): ProductDto {
        return ProductDto(
            entity.sku,
            entity.name,
            entity.description,
            entity.price,
            entity.createdAt,
            entity.updatedAt,
        )
    }

    override fun toEntity(domain: ProductDto): Product {
        return Product(
            domain.sku,
            domain.name,
            domain.description,
            domain.price,
            domain.createdAt,
            domain.updatedAt,
        )
    }

}