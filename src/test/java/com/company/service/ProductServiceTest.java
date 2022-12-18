package com.company.service;

import com.company.entity.ProductEntity;
import com.company.model.ProductModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductServiceTest {

    @Test
    void convert() {
        ProductService service = new ProductService();
        ProductEntity entity = new ProductEntity("Gilet", "Mac 3");

        ProductModel model = service.convert(entity);

        Assertions.assertEquals(entity.getName(), model.getName());
        Assertions.assertEquals(entity.getDescription(), model.getDescription());
    }
}