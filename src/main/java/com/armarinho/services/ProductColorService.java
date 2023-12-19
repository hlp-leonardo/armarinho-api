package com.armarinho.services;

import com.armarinho.daos.ProductColorDAO;
import com.armarinho.dtos.ProductColorDTO;
import com.armarinho.models.ProductColor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.NoResultException;

import java.util.ArrayList;
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
            ProductColorDAO dao = new ProductColorDAO();
            ProductColor createProductColor = dao.create(productColor);

            return createProductColor;
        } catch (Exception e) {
            throw new Exception("Product color could not be created.");
        }
    }

    public List<ProductColorDTO> getAll() throws Exception {

        ProductColorDAO dao = new ProductColorDAO();
        List<ProductColor> allProductColors = dao.getAll();

        List<ProductColorDTO> productColorDTOList = new ArrayList<>();

        for (int i = 0; i < allProductColors.size(); i++) {
            ProductColor existingProductColorDTO = allProductColors.get(i);
            if (existingProductColorDTO != null) {
                ProductColorDTO productColorDTO = new ProductColorDTO();
                productColorDTO.setId(existingProductColorDTO.getId());
                productColorDTO.setName(existingProductColorDTO.getName());
                productColorDTOList.add(productColorDTO);
            }
        }

        return productColorDTOList;
    }

    public ProductColorDTO getOne(Integer id) throws Exception {

        checkIdNull(id);

        try {
            ProductColorDAO dao = new ProductColorDAO();
            ProductColor productColor = dao.getOne(id);

            ProductColorDTO productColorDTO = new ProductColorDTO();
            productColorDTO.setId(productColor.getId());
            productColorDTO.setName(productColor.getName());

            return productColorDTO;
        } catch (NoResultException e) {
            throw new Exception("Product color did not find with given id.");
        }
    }

    public ProductColor update(Integer id, ProductColor productColor) throws Exception {

        checkIdNull(id);
        checkIfColorNameIsBlank(productColor);
        checkIfColorNameExists(productColor);

        ProductColorDAO dao = new ProductColorDAO();
        ProductColor updateProductColor = dao.update(id, productColor);

        return updateProductColor;
    }

    public void delete(int id) throws Exception {

        checkIdNull(id);

        try {
            ProductColorDAO dao = new ProductColorDAO();
            dao.delete(id);
        } catch (Exception e) {
            throw new Exception("Product color could not be deleted.");
        }
    }
}
