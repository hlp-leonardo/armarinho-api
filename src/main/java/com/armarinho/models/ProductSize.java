package com.armarinho.models;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT_SIZES")
public class ProductSize {

    @Id
    @Column(name = "PRODUCT_SIZE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "PRODUCT_SIZE_NAME")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
