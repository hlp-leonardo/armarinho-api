package com.armarinho.daos;

import com.armarinho.models.ProductSize;

import jakarta.persistence.*;

import java.util.List;

public class ProductSizeDao {

    private EntityManager createEntityManager() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("armarinho_pu");
        EntityManager em = emf.createEntityManager();

        return em;
    }

    private TypedQuery createTypedQuerySingleResult(int id) {

        EntityManager em = createEntityManager();
        TypedQuery<ProductSize> query = em.createQuery("select p from ProductSize p where p.id = :id", ProductSize.class);
        query.setParameter("id", id);

        return query;
    }

    private TypedQuery createTypedQueryList() {

        EntityManager em = createEntityManager();
        TypedQuery<ProductSize> queryList = em.createQuery("select p from ProductSize p", ProductSize.class);

        return queryList;
    }

    public ProductSize create(ProductSize productSize) {

        EntityManager em = createEntityManager();
        productSize.setId(productSize.getId());
        productSize.setName(productSize.getName());

        em.getTransaction().begin();
        em.persist(productSize);
        em.getTransaction().commit();

        return productSize;
    }

    public List<ProductSize> getAll() {

        TypedQuery<ProductSize> query = createTypedQueryList();
        List<ProductSize> list = query.getResultList();

        return list;
    }

    public ProductSize getOne(int id) {

        TypedQuery<ProductSize> query = createTypedQuerySingleResult(id);
        ProductSize productSize = query.getSingleResult();

        return productSize;
    }

    public ProductSize update(Integer id, ProductSize productSize) {

        EntityManager em = createEntityManager();
        TypedQuery<ProductSize> query = createTypedQuerySingleResult(id);

        ProductSize existingProductSize = query.getSingleResult();
        existingProductSize.setName(productSize.getName());
        productSize = existingProductSize;

        em.getTransaction().begin();
        em.merge(productSize);
        em.getTransaction().commit();

        return productSize;
    }

    public void delete(Integer id) {

        EntityManager em = createEntityManager();
        TypedQuery<ProductSize> query = em.createQuery("select p from ProductSize p where p.id = :id", ProductSize.class);
        query.setParameter("id", id);

        ProductSize productSize = query.getSingleResult();

        em.getTransaction().begin();
        em.remove(productSize);
        em.getTransaction().commit();
    }
}
