package com.armarinho.services;

import com.armarinho.daos.ProductTypeDAO;
import com.armarinho.dtos.ProductTypeDTO;
import com.armarinho.models.ProductType;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.NoResultException;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class ProductTypeService {

    @Inject
    private ProductTypeDAO dao;

    private void checkIdNull(Integer id) throws Exception {

        if (id == null) {
            throw new Exception("Product type id null or invalid.");
        }
    }

    private void checkIfTypeNameIsBlank(ProductType productType) throws Exception {

        productType.setName(productType.getName().trim());
        String checkName = productType.getName();

        if (checkName.isEmpty()) {
            throw new Exception("Product size name can not be blank.");
        }
    }

    public void checkIfTypeNameExists(ProductType productType) throws Exception {

        productType.setName(productType.getName().trim());
        String newTypeName = productType.getName();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("armarinho_pu");
        EntityManager em = emf.createEntityManager();

        TypedQuery<ProductType> queryList = em.createQuery("select p from ProductType p", ProductType.class);
        List<ProductType> list = queryList.getResultList();

        for (Integer i=1; i< list.size(); i++) {
            ProductType existingTypeName = list.get(i);
            existingTypeName.getName();
            if (existingTypeName.getName().equals(newTypeName)) {
                throw new Exception("Product type name already exists.");
            }
        }
    }

    public ProductTypeDTO create(ProductType productType) throws Exception {

        checkIfTypeNameIsBlank(productType);
        checkIfTypeNameExists(productType);

        try {
            ProductType createProductType = dao.create(productType);

            ProductTypeDTO productTypeDTO = new ProductTypeDTO();
            productTypeDTO.setId(createProductType.getId());
            productTypeDTO.setName(createProductType.getName());

            return productTypeDTO;
        } catch (Exception e) {
            throw new Exception("Product type could not be created.");
        }
    }

    public List<ProductTypeDTO> getAll() throws Exception {

        List<ProductType> allProductTypes = dao.getAll();

        List<ProductTypeDTO> productTypeDTOList = new ArrayList<>();

        for (int i=0; i<allProductTypes.size(); i++) {
            ProductType existingProductTypeDTO = allProductTypes.get(i);
            if (existingProductTypeDTO != null) {
                ProductTypeDTO productTypeDTO = new ProductTypeDTO();
                productTypeDTO.setId(existingProductTypeDTO.getId());
                productTypeDTO.setName(existingProductTypeDTO.getName());
                productTypeDTOList.add(productTypeDTO);
            }
        }

        return productTypeDTOList;
    }

    public ProductTypeDTO getOne(Integer id) throws Exception {

        checkIdNull(id);

        try {
            ProductType productType = dao.getOne(id);

            ProductTypeDTO productTypeDTO = new ProductTypeDTO();
            productTypeDTO.setId(productType.getId());
            productTypeDTO.setName(productType.getName());

            return productTypeDTO;
        } catch (NoResultException e) {
            throw new Exception("Product type did not find with given id.");
        }
    }

    public ProductTypeDTO update(Integer id, ProductType productType) throws Exception {

        checkIdNull(id);
        checkIfTypeNameIsBlank(productType);
        checkIfTypeNameExists(productType);

        ProductType updateProductType = dao.update(id, productType);

        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setId(updateProductType.getId());
        productTypeDTO.setName(updateProductType.getName());

        return productTypeDTO;
    }

    public void delete(Integer id) throws Exception {

        checkIdNull(id);

        try {
            dao.delete(id);
        } catch (Exception e) {
            throw new Exception("Product type could not be deleted.");
        }
    }
}
