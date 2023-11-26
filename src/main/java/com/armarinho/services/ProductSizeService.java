package com.armarinho.services;

import com.armarinho.daos.ProductSizeDao;
import com.armarinho.models.ProductSize;
import jakarta.persistence.NoResultException;

import java.util.List;

public class ProductSizeService {

    private void checkIdNull(Integer id) throws Exception {

        if (id == null) {
            throw new Exception("Product size id null or invalid.");
        }
    }

    public void checkProductSizeName(ProductSize productSize) throws Exception {

        productSize.setName(productSize.getName().trim());
        String checkName = productSize.getName();

        if (checkName.length() < 1) {
            throw new Exception("Product size name can't be blank.");
        }
    }

    public ProductSize create(ProductSize productSize) throws Exception {

        checkProductSizeName(productSize);

        try {
            ProductSizeDao dao = new ProductSizeDao();
            ProductSize createService = dao.create(productSize);

            return createService;
        } catch (Exception e) {
            throw new Exception("Product size could not be created.");
        }
    }

    public List<ProductSize> getAll() {

        ProductSizeDao dao = new ProductSizeDao();
        List<ProductSize> getAllServiceList = dao.getAll();

        return getAllServiceList;
    }

    public ProductSize getOne(Integer id) throws Exception {

        checkIdNull(id);

        try {
            ProductSizeDao dao = new ProductSizeDao();
            ProductSize getOneService = dao.getOne(id);

            return getOneService;
        } catch (NoResultException e) {
            throw new Exception("Product size did not find with given id.");
        }
    }

    public ProductSize update(Integer id, ProductSize productSize) throws Exception {

        checkIdNull(id);
        checkProductSizeName(productSize);

        ProductSizeDao dao = new ProductSizeDao();
        ProductSize updateService = dao.update(id, productSize);

        return updateService;
    }

    public void delete(Integer id) throws Exception {

        checkIdNull(id);

        try {
            ProductSizeDao dao = new ProductSizeDao();
            dao.delete(id);
        } catch (Exception e) {
            throw new Exception("Product size could not be deleted.");
        }
    }
}
