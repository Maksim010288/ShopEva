package com.company.model;

import com.company.entity.ProductEntity;
import lombok.Data;

@Data
public class ProductEntityModel {

    private String name;
    private String description;

    public ProductEntityModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ProductEntityModel getProductModel(ProductEntity entity){
        return new ProductEntityModel(entity.getName(), entity.getDescription());
    }
}
