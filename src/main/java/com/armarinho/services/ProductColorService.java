package com.armarinho.services;

import com.armarinho.daos.ProductColorDao;
import com.armarinho.models.ProductColor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProductColorService {

    private void checkIdNull(Integer id) throws Exception {

        if (id == null) {
            throw new Exception("Product color id is null or invalid.");
        }
    }

    private void checkIfColorNameIsBlank(ProductColor productColor) throws Exception {

        productColor.setName(productColor.getName().trim());
        String checkName = productColor.getName();

        if (checkName.isEmpty()) {
            throw new Exception("Product color name can not be blank.");
        }
    }

    public void checkIfColorNameExists(ProductColor productColor) throws Exception {

        productColor.setName(productColor.getName().trim());
        String newColorName = productColor.getName();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("armarinho_pu");
        EntityManager em = emf.createEntityManager();

        TypedQuery<ProductColor> queryList = em.createQuery("select p from ProductColor p", ProductColor.class);
        List<ProductColor> list = queryList.getResultList();

        for (Integer i=1; i< list.size(); i++) {
            ProductColor existingColorName = list.get(i);
            existingColorName.getName();
            if (existingColorName.getName().equals(newColorName)) {
                throw new Exception("Product color name already exists.");
            }
        }
    }

    public ProductColor create(ProductColor productColor) throws Exception {

        checkIfColorNameIsBlank(productColor);
        checkIfColorNameExists(productColor);

        try {
            ProductColorDao dao = new ProductColorDao();
            ProductColor createService = dao.create(productColor);

            return createService;
        } catch (Exception e) {
            throw new Exception("Product color could not be created.");
        }
    }

    public List<ProductColor> getAll() {

        ProductColorDao dao = new ProductColorDao();
        List<ProductColor> getAllServiceList = dao.getAll();

        return getAllServiceList;
    }

    public ProductColor getOne(Integer id) throws Exception {

        ProductColorDao dao = new ProductColorDao();
        ProductColor getOneService = dao.getOne(id);

        return getOneService;
    }

    public ProductColor update(int id, ProductColor productColor) throws Exception {

        checkIdNull(id);
        checkIfColorNameIsBlank(productColor);
        checkIfColorNameExists(productColor);

        ProductColorDao dao = new ProductColorDao();
        ProductColor updateService = dao.update(id, productColor);

        return updateService;
    }

    public void delete(int id) throws Exception {

        checkIdNull(id);

        ProductColorDao dao = new ProductColorDao();
        dao.delete(id);
    }
}
