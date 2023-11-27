package com.armarinho.resources;

import com.armarinho.models.ProductColor;
import com.armarinho.services.ProductColorService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/product-colors")
public class ProductColorResource {

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public ProductColor create(ProductColor productColor) throws Exception {

        ProductColorService service = new ProductColorService();
        ProductColor createResource = service.create(productColor);

        return createResource;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<ProductColor> getAll() throws Exception {

        ProductColorService service = new ProductColorService();
        List<ProductColor> getAllResourceList = service.getAll();

        return getAllResourceList;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProductColor getOne(@PathParam("id") int id) throws Exception {

        ProductColorService service = new ProductColorService();
        ProductColor getOneResource = service.getOne(id);

        return getOneResource;
    }

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProductColor update(@PathParam("id") int id, ProductColor productColor) throws Exception {

        ProductColorService service = new ProductColorService();
        ProductColor updateResource = service.update(id, productColor);

        return updateResource;
    }

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void delete(@PathParam("id") int id) throws Exception {

        ProductColorService service = new ProductColorService();
        service.delete(id);

    }
}
