package com.armarinho.daos;

import com.armarinho.models.ProductColor;

import jakarta.persistence.*;

import java.util.List;

public class ProductColorDAO {

    private EntityManager createEntityManager() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("armarinho_pu");
        EntityManager em = emf.createEntityManager();

        return em;
    }

    private TypedQuery createTypedQuerySingleResult(int id) {

        EntityManager em = createEntityManager();
        TypedQuery<ProductColor> query = em.createQuery("select p from ProductColor p where p.id = :id", ProductColor.class);
        query.setParameter("id", id);

        return query;
    }

    private TypedQuery createTypedQueryList() {

        EntityManager em = createEntityManager();
        TypedQuery<ProductColor> queryList = em.createQuery("select p from ProductColor p", ProductColor.class);

        return queryList;
    }

    public ProductColor create(ProductColor productColor) throws Exception {

        EntityManager em = createEntityManager();

        productColor.setId(productColor.getId());
        productColor.setName(productColor.getName());

        em.getTransaction().begin();
        em.persist(productColor);
        em.getTransaction().commit();

        return productColor;
    }

    public List<ProductColor> getAll() {

        TypedQuery<ProductColor> query = createTypedQueryList();
        List<ProductColor> list = query.getResultList();

        return list;
    }

    public ProductColor getOne(Integer id) throws Exception {

        TypedQuery<ProductColor> query = createTypedQuerySingleResult(id);
        ProductColor productColor = query.getSingleResult();

        return productColor;
    }

    public ProductColor update(Integer id, ProductColor productColor) throws Exception {

        EntityManager em = createEntityManager();
        TypedQuery<ProductColor> query = createTypedQuerySingleResult(id);

        ProductColor existingProductColor = query.getSingleResult();
        existingProductColor.setName(productColor.getName());
        productColor = existingProductColor;

        em.getTransaction().begin();
        em.merge(productColor);
        em.getTransaction().commit();

        return productColor;
    }

    public void delete(Integer id) throws Exception {

        EntityManager em = createEntityManager();
        TypedQuery<ProductColor> query = em.createQuery("select p from ProductColor p where p.id = :id", ProductColor.class);
        query.setParameter("id", id);

        ProductColor productColor = query.getSingleResult();

        em.getTransaction().begin();
        em.remove(productColor);
        em.getTransaction().commit();
    }
}
