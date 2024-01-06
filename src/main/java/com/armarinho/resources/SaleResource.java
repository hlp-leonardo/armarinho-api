package com.armarinho.resources;

import com.armarinho.models.Sale;
import com.armarinho.services.SaleService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/sales")
public class SaleResource {

    @Inject
    private SaleService service;

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Sale create(Sale sale) {

        Sale createSale = service.create(sale);

        return createSale;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Sale> getAll() {

        List<Sale> allSales = service.getAll();

        return allSales;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Sale getOne(@PathParam("id") int id) throws Exception {

        Sale sale = service.getOne(id);

        return sale;
    }

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Sale update(@PathParam("id") int id, Sale sale) throws Exception {

        Sale updateSale = service.update(id, sale);

        return updateSale;
    }

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void delete(@PathParam("id") int id) throws Exception {

        service.delete(id);
    }
}
