package com.armarinho.dtos;

public class ProductDTO {

    private Integer id;

    private String name;

    private double price;

    private ProductTypeDTO productTypeDTO;

    private ProductColorDTO productColorDTO;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductTypeDTO getProductTypeDTO() {
        return productTypeDTO;
    }

    public void setProductTypeDTO(ProductTypeDTO productTypeDTO) {
        this.productTypeDTO = productTypeDTO;
    }

    public ProductColorDTO getProductColorDTO() {
        return productColorDTO;
    }

    public void setProductColorDTO(ProductColorDTO productColorDTO) {
        this.productColorDTO = productColorDTO;
    }
}
