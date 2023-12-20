package com.armarinho.resources;

import com.armarinho.dtos.ProductColorDTO;
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
    public ProductColorDTO create(ProductColor productColor) throws Exception {

        ProductColorService service = new ProductColorService();
        ProductColorDTO createProductColor = service.create(productColor);

        return createProductColor;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<ProductColorDTO> getAll() throws Exception {

        ProductColorService service = new ProductColorService();
        List<ProductColorDTO> allProductColors = service.getAll();

        return allProductColors;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProductColorDTO getOne(@PathParam("id") Integer id) throws Exception {

        ProductColorService service = new ProductColorService();
        ProductColorDTO productColor = service.getOne(id);

        return productColor;
    }

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProductColorDTO update(@PathParam("id") Integer id, ProductColor productColor) throws Exception {

        ProductColorService service = new ProductColorService();
        ProductColorDTO updateProductColor = service.update(id, productColor);

        return updateProductColor;
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
