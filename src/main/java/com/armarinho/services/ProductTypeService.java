package com.armarinho.services;

import com.armarinho.daos.ProductTypeDao;
import com.armarinho.models.ProductType;
import jakarta.persistence.NoResultException;

import java.util.List;

public class ProductTypeService {

    private void checkIdNull(Integer id) throws Exception {

        if (id == null) {
            throw new Exception("Product type id null or invalid.");
        }
    }

    public void checkProductTypeName(ProductType productType) throws Exception {
        productType.setName(productType.getName().trim());
        String checkName = productType.getName();
        if (checkName.length() < 1) {
            throw new Exception("Product type name can't be blank.");
        }
    }

    public ProductType create(ProductType productType) throws Exception {

        checkProductTypeName(productType);

        try {
            ProductTypeDao dao = new ProductTypeDao();
            ProductType createService = dao.create(productType);

            return createService;
        } catch (Exception e) {
            throw new Exception("Product type could not be created.");
        }
    }

    public List<ProductType> getAll() {

        ProductTypeDao dao = new ProductTypeDao();
        List<ProductType> getAllServiceList = dao.getAll();

        return getAllServiceList;
    }

    public ProductType getOne(Integer id) throws Exception {

        checkIdNull(id);

        try {
            ProductTypeDao dao = new ProductTypeDao();
            ProductType getOneService = dao.getOne(id);

            return getOneService;
        } catch (NoResultException e) {
            throw new Exception("Product type did not find with given id.");
        }
    }

    public ProductType update(Integer id, ProductType productType) throws Exception {

        checkIdNull(id);
        checkProductTypeName(productType);

        ProductTypeDao dao = new ProductTypeDao();
        ProductType updateService = dao.update(id, productType);

        return updateService;
    }

    public void delete(Integer id) throws Exception {

        checkIdNull(id);

        try {
            ProductTypeDao dao = new ProductTypeDao();
            dao.delete(id);
        } catch (Exception e) {
            throw new Exception("Product type could not be deleted.");
        }
    }
}
