package com.company.controller;

import com.company.entity.ProductEntity;
import com.company.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shop/product")
public class ProductController {

    @Autowired
    ProductService productService;


    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody ProductEntity productEntity) {
        ProductEntity entity = new ProductEntity(
                productEntity.getName(),
                productEntity.getDescription());
        productService.createProduct(entity);
        return ResponseEntity.ok().body("Added a new product " + productEntity.getName());
    }

    @GetMapping(value = "/all")
    public ResponseEntity getProductAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping(value = "/")
    public ResponseEntity findEverythingExceptCharE(String nameFilter) {
        return ResponseEntity.ok(productService.getProductByFilter(nameFilter));
    }

}
