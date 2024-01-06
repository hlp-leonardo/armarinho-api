package com.armarinho.daos;

import com.armarinho.dtos.ProductDTO;
import com.armarinho.models.Product;
import com.armarinho.models.Sale;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Stateless
public class SaleDAO {

    private EntityManager createEntityManager() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("armarinho_pu");
        EntityManager em = emf.createEntityManager();

        return em;
    }

    private TypedQuery createTypedQuerySingleResult(int id) {

        EntityManager em = createEntityManager();
        TypedQuery<Sale> query = em.createQuery("select p from Sale p where p.id = :id", Sale.class);
        query.setParameter("id", id);

        return query;
    }

    private TypedQuery createTypedQueryList() {

        EntityManager em = createEntityManager();
        TypedQuery<Sale> queryList = em.createQuery("select p from Sale p", Sale.class);

        return queryList;
    }

    public Sale create(Sale sale) {

        EntityManager em = createEntityManager();

        sale.setId(sale.getId());
        sale.setDate(Date.from(Instant.now()));

        em.getTransaction().begin();
        em.persist(sale);
        em.getTransaction().commit();

        return sale;
    }

    public List<Sale> getAll() {

        TypedQuery<Sale> query = createTypedQueryList();
        List<Sale> saleList = query.getResultList();

        return saleList;
    }

    public Sale getOne(int id) {

        TypedQuery<Sale> query = createTypedQuerySingleResult(id);
        Sale sale = query.getSingleResult();

        return sale;
    }

    public Sale update(int id, Sale sale) {

        EntityManager em = createEntityManager();
        TypedQuery<Sale> query = createTypedQuerySingleResult(id);

        Sale existingSale = query.getSingleResult();
        existingSale.setDate(sale.getDate());
        sale = existingSale;

        em.getTransaction().begin();
        em.merge(sale);
        em.getTransaction().commit();

        return sale;
    }

    public void delete(int id) {

        EntityManager em = createEntityManager();
        TypedQuery<Sale> query = em.createQuery("select p from Sale p where p.id = :id", Sale.class);
        query.setParameter("id", id);

        Sale sale = query.getSingleResult();

        em.getTransaction().begin();
        em.remove(sale);
        em.getTransaction().commit();
    }
}
