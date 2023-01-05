package com.imedia.Store.Services

import com.imedia.Store.Dtos.ProductDto
import com.imedia.Store.Models.Product
import com.imedia.Store.Repos.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.ZonedDateTime
import kotlin.math.log

@Service
class ProductService(){
    @Autowired
    lateinit var productRepository: ProductRepository;
    @Autowired
    lateinit var  productMapper: ProductMapper
    fun findProductBySku(sku: String): ProductDto? {
        return productMapper.fromEntity(productRepository.findBySku(sku));
    }

    fun findProducts(): MutableList<Product> {
        return productRepository.findAll();
    }

    fun saveProdcut(product: Product): Product{
        return productRepository.save(product);
    }

    fun updateProduct(product: Product): Product{
        var myProduct: Product = productRepository.findBySku(product.sku);
        myProduct.name = product.name;
        myProduct.price = product.price;
        myProduct.description = product.description;
        myProduct.updatedAt = ZonedDateTime.now();

        saveProdcut(myProduct);
        return myProduct;
    }
}