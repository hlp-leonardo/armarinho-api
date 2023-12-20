package com.armarinho.services;

import com.armarinho.daos.ProductSizeDAO;
import com.armarinho.dtos.ProductSizeDTO;
import com.armarinho.models.ProductSize;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.NoResultException;

import java.util.ArrayList;
import java.util.List;

public class ProductSizeService {

    private void checkIdNull(Integer id) throws Exception {

        if (id == null) {
            throw new Exception("Product size id null or invalid.");
        }
    }

    private void checkIfSizeNameIsBlank(ProductSize productSize) throws Exception {

        productSize.setName(productSize.getName().trim());
        String checkName = productSize.getName();

        if (checkName.isEmpty()) {
            throw new Exception("Product size name can not be blank.");
        }
    }

    public void checkIfSizeNameExists(ProductSize productSize) throws Exception {

        productSize.setName(productSize.getName().trim());
        String newSizeName = productSize.getName();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("armarinho_pu");
        EntityManager em = emf.createEntityManager();

        TypedQuery<ProductSize> queryList = em.createQuery("select p from ProductSize p", ProductSize.class);
        List<ProductSize> list = queryList.getResultList();

        for (Integer i=1; i< list.size(); i++) {
            ProductSize existingSizeName = list.get(i);
            existingSizeName.getName();
            if (existingSizeName.getName().equals(newSizeName)) {
                throw new Exception("Product color name already exists.");
            }
        }
    }

    public ProductSizeDTO create(ProductSize productSize) throws Exception {

        checkIfSizeNameIsBlank(productSize);
        checkIfSizeNameExists(productSize);

        try {
            ProductSizeDAO dao = new ProductSizeDAO();
            ProductSize createProductSize = dao.create(productSize);

            ProductSizeDTO productSizeDTO = new ProductSizeDTO();
            productSizeDTO.setId(createProductSize.getId());
            productSizeDTO.setName(createProductSize.getName());

            return productSizeDTO;
        } catch (Exception e) {
            throw new Exception("Product size could not be created.");
        }
    }

    public List<ProductSizeDTO> getAll() {

        ProductSizeDAO dao = new ProductSizeDAO();
        List<ProductSize> allProductSizes = dao.getAll();

        List<ProductSizeDTO> productSizeDTOLis = new ArrayList<>();

        for (int i=0; i<allProductSizes.size(); i++) {
            ProductSize existingProductSizeDTO = allProductSizes.get(i);
            if (existingProductSizeDTO != null) {
                ProductSizeDTO productSizeDTO = new ProductSizeDTO();
                productSizeDTO.setId(existingProductSizeDTO.getId());
                productSizeDTO.setName(existingProductSizeDTO.getName());
                productSizeDTOLis.add(productSizeDTO);
            }
        }

        return productSizeDTOLis;
    }

    public ProductSizeDTO getOne(Integer id) throws Exception {

        checkIdNull(id);

        try {
            ProductSizeDAO dao = new ProductSizeDAO();
            ProductSize productSize = dao.getOne(id);

            ProductSizeDTO productSizeDTO = new ProductSizeDTO();
            productSizeDTO.setId(productSize.getId());
            productSizeDTO.setName(productSize.getName());

            return productSizeDTO;
        } catch (NoResultException e) {
            throw new Exception("Product size did not find with given id.");
        }
    }

    public ProductSizeDTO update(Integer id, ProductSize productSize) throws Exception {

        checkIdNull(id);
        checkIfSizeNameIsBlank(productSize);
        checkIfSizeNameExists(productSize);

        ProductSizeDAO dao = new ProductSizeDAO();
        ProductSize updateProductSize = dao.update(id, productSize);

        ProductSizeDTO productSizeDTO = new ProductSizeDTO();
        productSizeDTO.setId(updateProductSize.getId());
        productSizeDTO.setName(updateProductSize.getName());

        return productSizeDTO;
    }

    public void delete(Integer id) throws Exception {

        checkIdNull(id);

        try {
            ProductSizeDAO dao = new ProductSizeDAO();
            dao.delete(id);
        } catch (Exception e) {
            throw new Exception("Product size could not be deleted.");
        }
    }
}
