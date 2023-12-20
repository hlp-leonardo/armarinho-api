package com.armarinho.resources;

import com.armarinho.dtos.ProductTypeDTO;
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
    public ProductTypeDTO create(ProductType productType) throws Exception {

        ProductTypeService service = new ProductTypeService();
        ProductTypeDTO createProductType = service.create(productType);

        return createProductType;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<ProductTypeDTO> getAll() throws Exception {

        ProductTypeService service = new ProductTypeService();
        List<ProductTypeDTO> allProductTypes = service.getAll();

        return allProductTypes;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProductTypeDTO getOne(@PathParam("id") int id) throws Exception {

        ProductTypeService service = new ProductTypeService();
        ProductTypeDTO ProductType = service.getOne(id);

        return ProductType;
    }

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProductTypeDTO update(@PathParam("id") Integer id, ProductType productType) throws Exception {

        ProductTypeService service = new ProductTypeService();
        ProductTypeDTO updateProductType = service.update(id, productType);

        return updateProductType;
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
