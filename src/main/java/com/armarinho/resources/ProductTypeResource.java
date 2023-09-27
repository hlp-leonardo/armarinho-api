package com.armarinho.resources;

import com.armarinho.models.ProductType;
import jakarta.persistence.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/product-types")
public class ProductTypeResource {

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public ProductType create (ProductType productType) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("armarinho_pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(productType);
        em.getTransaction().commit();

        return productType;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<ProductType> getAll () {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("armarinho_pu");
        EntityManager em = emf.createEntityManager();
        TypedQuery<ProductType> query = em.createQuery("select p from ProductType p", ProductType.class);
        List<ProductType> list = query.getResultList();

        return list;
    }

}
