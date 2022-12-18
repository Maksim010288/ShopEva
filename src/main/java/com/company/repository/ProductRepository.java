package com.company.repository;

import com.company.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Query(value = "select * from products p where p.name not regexp :nameFilter limit :size offset :offset",
            nativeQuery = true)
    List<ProductEntity> findByNameRegexpNot(String nameFilter, int size, int offset);
}
