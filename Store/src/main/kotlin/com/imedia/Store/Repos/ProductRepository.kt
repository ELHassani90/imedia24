package com.imedia.Store.Repos

import com.imedia.Store.Dtos.ProductDto
import com.imedia.Store.Models.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<Product, String> {
    fun findBySku(sku: String): Product;
}