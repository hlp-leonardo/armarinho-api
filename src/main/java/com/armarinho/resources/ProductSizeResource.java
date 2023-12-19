package com.armarinho.resources;

import com.armarinho.dtos.ProductSizeDTO;
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
        ProductSize createProductSize = service.create(productSize);

        return createProductSize;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<ProductSizeDTO> getAll() throws Exception {

        ProductSizeService service = new ProductSizeService();
        List<ProductSizeDTO> allProductSizes = service.getAll();

        return allProductSizes;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProductSizeDTO getOne(@PathParam("id") int id) throws Exception {

        ProductSizeService service = new ProductSizeService();
        ProductSizeDTO productSize = service.getOne(id);

        return productSize;
    }

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProductSize update(@PathParam("id") Integer id, ProductSize productSize) throws Exception {

        ProductSizeService service = new ProductSizeService();
        ProductSize updateProductSize = service.update(id, productSize);

        return updateProductSize;
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
