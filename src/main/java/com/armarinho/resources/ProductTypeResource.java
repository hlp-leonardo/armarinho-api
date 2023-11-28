package com.armarinho.resources;

import com.armarinho.models.ProductType;
import com.armarinho.services.ProductTypeService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/product-types")
public class ProductTypeResource {

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public ProductType create(ProductType productType) throws Exception {

        ProductTypeService service = new ProductTypeService();
        ProductType createResource = service.create(productType);

        return createResource;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<ProductType> getAll() throws Exception {

        ProductTypeService service = new ProductTypeService();
        List<ProductType> getAllResourceList = service.getAll();

        return getAllResourceList;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProductType getOne(@PathParam("id") int id) throws Exception {

        ProductTypeService service = new ProductTypeService();
        ProductType getOneResource = service.getOne(id);

        return getOneResource;
    }

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProductType update(@PathParam("id") Integer id, ProductType productType) throws Exception {

        ProductTypeService service = new ProductTypeService();
        ProductType updateResource = service.update(id, productType);

        return updateResource;
    }

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) throws Exception {

        ProductTypeService service = new ProductTypeService();
        service.delete(id);
    }
}
