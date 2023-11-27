package com.armarinho.models;

import jakarta.persistence.*;

@Entity
@Table(name = "SALE_PRODUCTS")
public class SaleProduct {

    @Id
    @Column(name = "SALE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "SALE_FK")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_FK")
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
