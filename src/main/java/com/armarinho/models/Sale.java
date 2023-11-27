package com.armarinho.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SALES")
public class Sale {

    @Id
    @Column(name = "SALE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SALE_DATE")
    private Date date;

    @OneToMany(mappedBy = "sale")
    private List<SaleProduct> sale;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<SaleProduct> getSale() {
        return sale;
    }

    public void setSale(List<SaleProduct> sale) {
        this.sale = sale;
    }
}
