package com.armarinho.daos;

import com.armarinho.models.Product;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class ProductDAO {

    private EntityManager createEntityManager() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("armarinho_pu");
        EntityManager em = emf.createEntityManager();

        return em;
    }

    private TypedQuery createTypedQuerySingleResult(int id) {

        EntityManager em = createEntityManager();
        TypedQuery<Product> query = em.createQuery("select p from Product p where p.id = :id", Product.class);
        query.setParameter("id", id);

        return query;
    }

    private TypedQuery createTypedQueryList() {

        EntityManager em = createEntityManager();
        TypedQuery<Product> queryList = em.createQuery("select p from Product p", Product.class);

        return queryList;
    }

    public Product create(Product product) {

        EntityManager em = createEntityManager();

        product.setId(product.getId());
        product.setName(product.getName());

        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();

        return product;
    }

    public List<Product> getAll() {

        TypedQuery<Product> query = createTypedQueryList();
        List<Product> productList = query.getResultList();

        return productList;
    }

    public Product getOne(int id) {

        TypedQuery<Product> query = createTypedQuerySingleResult(id);
        Product product = query.getSingleResult();

        return product;
    }

    public Product update(Integer id, Product product) {

        EntityManager em = createEntityManager();
        TypedQuery<Product> query = createTypedQuerySingleResult(id);

        Product existingProduct = query.getSingleResult();
        existingProduct.setName(product.getName());
        product = existingProduct;

        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();

        return product;
    }

    public void delete(Integer id) {

        EntityManager em = createEntityManager();
        TypedQuery<Product> query = em.createQuery("select p from Product p where p.id = :id", Product.class);
        query.setParameter("id", id);

        Product productType = query.getSingleResult();

        em.getTransaction().begin();
        em.remove(productType);
        em.getTransaction().commit();
    }
}
