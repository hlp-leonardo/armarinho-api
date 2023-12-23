package com.armarinho.resources;

import com.armarinho.dtos.ProductColorDTO;
import com.armarinho.models.ProductColor;
import com.armarinho.services.ProductColorService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/product-colors")
public class ProductColorResource {

    @Inject
    private ProductColorService service;

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public ProductColorDTO create(ProductColor productColor) throws Exception {

        ProductColorDTO createProductColor = service.create(productColor);

        return createProductColor;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<ProductColorDTO> getAll() throws Exception {

        List<ProductColorDTO> allProductColors = service.getAll();

        return allProductColors;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProductColorDTO getOne(@PathParam("id") Integer id) throws Exception {

        ProductColorDTO productColor = service.getOne(id);

        return productColor;
    }

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProductColorDTO update(@PathParam("id") Integer id, ProductColor productColor) throws Exception {

        ProductColorDTO updateProductColor = service.update(id, productColor);

        return updateProductColor;
    }

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void delete(@PathParam("id") int id) throws Exception {

        service.delete(id);

    }
}
