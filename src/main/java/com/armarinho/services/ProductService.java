package com.armarinho.services;

import com.armarinho.daos.ProductDAO;
import com.armarinho.dtos.ProductDTO;
import com.armarinho.models.Product;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class ProductService {

    @Inject
    private ProductDAO dao;

    private void checkIdNull(Integer id) throws Exception {

        if (id == null) {
            throw new Exception("Product id null or invalid.");
        }
    }

    private void checkIfProductNameIsBlank(Product product) throws Exception {

        product.setName(product.getName().trim());
        String checkName = product.getName();

        if (checkName.isEmpty()) {
            throw new Exception("Product name can not be blank.");
        }
    }

    public void checkIfProductNameExists(Product product) throws Exception {

        product.setName(product.getName().trim());
        String newProductName = product.getName();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("armarinho_pu");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Product> queryList = em.createQuery("select p from Product p", Product.class);
        List<Product> list = queryList.getResultList();

        for (Integer i=1; i< list.size(); i++) {
            Product existingProductName = list.get(i);
            existingProductName.getName();
            if (existingProductName.getName().equals(newProductName)) {
                throw new Exception("Product name already exists.");
            }
        }
    }

    public ProductDTO create(Product product) throws Exception {

        checkIfProductNameIsBlank(product);
        checkIfProductNameExists(product);

        try {
            Product createProduct = dao.create(product);

            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(createProduct.getId());
            productDTO.setName(createProduct.getName());

            return productDTO;
        } catch (Exception e) {
            throw new Exception("Product could not be created.");
        }
    }

    public List<ProductDTO> getAll() throws Exception {

        List<Product> allProducts = dao.getAll();

        List<ProductDTO> productDTOList = new ArrayList<>();

        for (int i=0; i<allProducts.size(); i++) {
            Product existingProductDTO = allProducts.get(i);
            if (existingProductDTO != null) {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setId(existingProductDTO.getId());
                productDTO.setName(existingProductDTO.getName());
                productDTOList.add(productDTO);
            }
        }

        return productDTOList;
    }

    public ProductDTO getOne(Integer id) throws Exception {

        checkIdNull(id);

        try {
            Product product = dao.getOne(id);

            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());

            return productDTO;
        } catch (NoResultException e) {
            throw new Exception("Product did not find with given id.");
        }
    }

    public ProductDTO update(Integer id, Product product) throws Exception {

        checkIdNull(id);
        checkIfProductNameIsBlank(product);
        checkIfProductNameExists(product);

        Product updateProduct = dao.update(id, product);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(updateProduct.getId());
        productDTO.setName(updateProduct.getName());

        return productDTO;
    }

    public void delete(Integer id) throws Exception {

        checkIdNull(id);

        try {
            dao.delete(id);
        } catch (Exception e) {
            throw new Exception("Product could not be deleted.");
        }
    }
}

