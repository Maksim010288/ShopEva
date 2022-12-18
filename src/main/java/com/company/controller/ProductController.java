package com.company.controller;

import com.company.entity.ProductEntity;
import com.company.model.ProductModel;
import com.company.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shop/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestBody ProductEntity productEntity) {
        ProductEntity entity = new ProductEntity(
                productEntity.getName(),
                productEntity.getDescription());
        productService.createProduct(entity);
        return ResponseEntity
                .ok()
                .body("Added a new product " + productEntity.getName());
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ProductModel>> getProductAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<ProductModel>> getProductByFilter(@RequestParam String nameFilter,
                                                                 @RequestParam(required = false, defaultValue = "10") Integer size,
                                                                 @RequestParam(required = false, defaultValue = "0") Integer offset) {
        return ResponseEntity.ok(productService.getProductByFilter(nameFilter, size, offset));
    }

}
