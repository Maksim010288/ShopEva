package com.company.service;

import com.company.entity.ProductEntity;
import com.company.model.ProductEntityModel;
import com.company.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public ProductEntity createProduct(ProductEntity entity) {
        return repository.save(new ProductEntity(entity.getName(), entity.getDescription()));
    }

    public List<ProductEntityModel> getAll(){
        return repository.findAll().stream()
                .map(productEntity -> new ProductEntityModel(productEntity.getName(), productEntity.getDescription()))
                .collect(Collectors.toList());
    }

    private List<ProductEntity> findProductByFilter(String nameFilter) {
        List<ProductEntity> productEntities = null;
        if (nameFilter.equalsIgnoreCase("Е") || nameFilter.equalsIgnoreCase("E")) {
            productEntities = repository.findByNameRegexpNot("^" + nameFilter + ".*$");
        } else if (nameFilter.equalsIgnoreCase("Eva")) {
            productEntities = repository.findByNameRegexpNot("^.*[" + nameFilter + "].*$");
        }
        return productEntities;
    }

    public List<ProductEntityModel> getProductByFilter(String nameFilter) {
        return findProductByFilter(nameFilter).stream()
                .map(productEntity -> new ProductEntityModel(productEntity.getName(), productEntity.getDescription()))
                .collect(Collectors.toList());
    }
}
