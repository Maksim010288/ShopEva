package com.company.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    public ProductEntity(){}

    public ProductEntity(String name, String description){
        this.name = name;
        this.description = description;
    }
}
