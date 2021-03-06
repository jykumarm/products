package com.sample.products.controller;

import com.sample.products.model.ProductDTO;
import com.sample.products.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Tag(name = "products" , description = "The Products API")
public class ProductsController {

    private final ProductService productService;

    @GetMapping
    @ApiOperation(value = "fetches products info", notes = "fetches products info", tags = { "products"})
    public List<ProductDTO> getProducts(){
        return productService.getProducts();
    }
}
