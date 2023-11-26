package com.armarinho.resources;

import com.armarinho.models.ProductSize;
import com.armarinho.services.ProductSizeService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/product-sizes")
public class ProductSizeResource {

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public ProductSize create(ProductSize productSize) throws Exception {
        ProductSizeService service = new ProductSizeService();
        ProductSize createResource = service.create(productSize);

        return createResource;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<ProductSize> getAll() throws Exception {
        ProductSizeService service = new ProductSizeService();
        List<ProductSize> getAllResourceList = service.getAll();

        return getAllResourceList;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProductSize getOne(@PathParam("id") int id) throws Exception {
        ProductSizeService service = new ProductSizeService();
        ProductSize getOneResource = service.getOne(id);

        return getOneResource;
    }

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProductSize update(@PathParam("id") Integer id, ProductSize productSize) throws Exception {
        ProductSizeService service = new ProductSizeService();
        ProductSize updateResource = service.update(id, productSize);

        return updateResource;
    }

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) throws Exception {
        ProductSizeService service = new ProductSizeService();
        service.delete(id);
    }
}
