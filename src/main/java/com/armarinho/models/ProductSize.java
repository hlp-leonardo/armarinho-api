package com.armarinho.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PRODUCT_SIZES")
public class ProductSize {

    @Id
    @Column(name = "PRODUCT_SIZE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "PRODUCT_SIZE_NAME")
    private String name;

    @OneToMany(mappedBy = "productSize")
    private List<Product> product;

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

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
