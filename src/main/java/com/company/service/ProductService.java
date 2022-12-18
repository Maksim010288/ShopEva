package com.company.service;

import com.company.entity.ProductEntity;
import com.company.model.ProductModel;
import com.company.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public void createProduct(ProductEntity entity) {
        repository.save(new ProductEntity(entity.getName(), entity.getDescription()));
    }

    public List<ProductModel> getAll() {
        return repository.findAll()
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public List<ProductModel> getProductByFilter(String nameFilter, int size, int offset) {
        return repository.findByNameRegexpNot(nameFilter, size, offset)
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    protected ProductModel convert(ProductEntity productEntity){
        return new ProductModel(productEntity.getName(), productEntity.getDescription());
    }
}
