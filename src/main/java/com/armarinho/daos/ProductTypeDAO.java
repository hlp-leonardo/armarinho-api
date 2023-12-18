package com.armarinho.daos;

import com.armarinho.models.ProductType;

import jakarta.persistence.*;

import java.util.List;

public class ProductTypeDAO {

    private EntityManager createEntityManager() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("armarinho_pu");
        EntityManager em = emf.createEntityManager();

        return em;
    }

    private TypedQuery createTypedQuerySingleResult(int id) {

        EntityManager em = createEntityManager();
        TypedQuery<ProductType> query = em.createQuery("select p from ProductType p where p.id = :id", ProductType.class);
        query.setParameter("id", id);

        return query;
    }

    private TypedQuery createTypedQueryList() {

        EntityManager em = createEntityManager();
        TypedQuery<ProductType> queryList = em.createQuery("select p from ProductType p", ProductType.class);

        return queryList;
    }

    public ProductType create(ProductType productType) {

        EntityManager em = createEntityManager();

        productType.setId(productType.getId());
        productType.setName(productType.getName());

        em.getTransaction().begin();
        em.persist(productType);
        em.getTransaction().commit();

        return productType;
    }

    public List<ProductType> getAll() {

        TypedQuery<ProductType> query = createTypedQueryList();
        List<ProductType> productTypeList = query.getResultList();

        return productTypeList;
    }

    public ProductType getOne(int id) {

        TypedQuery<ProductType> query = createTypedQuerySingleResult(id);
        ProductType productType = query.getSingleResult();

        return productType;
    }

    public ProductType update(Integer id, ProductType productType) {

        EntityManager em = createEntityManager();
        TypedQuery<ProductType> query = createTypedQuerySingleResult(id);

        ProductType existingProductType = query.getSingleResult();
        existingProductType.setName(productType.getName());
        productType = existingProductType;

        em.getTransaction().begin();
        em.merge(productType);
        em.getTransaction().commit();

        return productType;
    }

    public void delete(Integer id) {

        EntityManager em = createEntityManager();
        TypedQuery<ProductType> query = em.createQuery("select p from ProductType p where p.id = :id", ProductType.class);
        query.setParameter("id", id);

        ProductType productType = query.getSingleResult();

        em.getTransaction().begin();
        em.remove(productType);
        em.getTransaction().commit();
    }
}
