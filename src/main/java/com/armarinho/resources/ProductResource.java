package com.armarinho.resources;


import com.armarinho.dtos.ProductDTO;
import com.armarinho.models.Product;
import com.armarinho.services.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/products")
public class ProductResource {

    @Inject
    private ProductService service;

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public ProductDTO create(Product product) throws Exception {

        ProductDTO createProduct = service.create(product);

        return createProduct;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<ProductDTO> getAll() throws Exception {

        List<ProductDTO> allProducts = service.getAll();

        return allProducts;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProductDTO getOne(@PathParam("id") int id) throws Exception {

        ProductDTO Product = service.getOne(id);

        return Product;
    }

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProductDTO update(@PathParam("id") Integer id, Product product) throws Exception {

        ProductDTO updateProduct = service.update(id, product);

        return updateProduct;
    }

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) throws Exception {

        service.delete(id);
    }
}
