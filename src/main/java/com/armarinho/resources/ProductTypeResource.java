package com.armarinho.resources;

import com.armarinho.dtos.ProductTypeDTO;
import com.armarinho.models.ProductType;
import com.armarinho.services.ProductTypeService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/product-types")
public class ProductTypeResource {

    @Inject
    private ProductTypeService service;

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public ProductTypeDTO create(ProductType productType) throws Exception {

        ProductTypeDTO createProductType = service.create(productType);

        return createProductType;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<ProductTypeDTO> getAll() throws Exception {

        List<ProductTypeDTO> allProductTypes = service.getAll();

        return allProductTypes;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProductTypeDTO getOne(@PathParam("id") int id) throws Exception {

        ProductTypeDTO ProductType = service.getOne(id);

        return ProductType;
    }

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProductTypeDTO update(@PathParam("id") Integer id, ProductType productType) throws Exception {

        ProductTypeDTO updateProductType = service.update(id, productType);

        return updateProductType;
    }

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) throws Exception {

        service.delete(id);
    }
}
