package com.imedia.Store.Controllers

import com.imedia.Store.Dtos.ProductDto
import com.imedia.Store.Models.Product
import com.imedia.Store.Services.ProductMapper
import com.imedia.Store.Services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class ProductController (private val productService: ProductService, private val productMapper: ProductMapper){


    @GetMapping("/products")
    fun getAllProducts(): MutableList<Product>? {
        return productService.findProducts();
    }

    @GetMapping("/product")
    fun getProduct(@RequestParam sku: String): ProductDto? {
        return productService.findProductBySku(sku);
    }
    @GetMapping("/product/skus")
    fun getProductsSkus(@RequestParam skus: List<String>): ArrayList<ProductDto>? {
        val productDtos= ArrayList<ProductDto>();
        for (sku in skus){
            productDtos.add(productService.findProductBySku(sku)!!);
        }
        return productDtos;
    }

    @PostMapping("/save")
    fun  saveProduct(@RequestBody product: Product): ProductDto? {
        return productMapper.fromEntity(productService.saveProdcut(product));
    }

    @PutMapping("/prodcut/update")
    fun  updateProduct(@RequestBody product: Product): ProductDto? {
        return productMapper.fromEntity(productService.updateProduct(product));
    }


}