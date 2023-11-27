package com.armarinho.resources;

import com.armarinho.models.Sale;
import com.armarinho.services.SaleService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/sales")
public class SaleResource {

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Sale create(Sale sale) {

        SaleService service = new SaleService();
        Sale createResource = service.create(sale);

        return createResource;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Sale> getAll() {

        SaleService service = new SaleService();
        List<Sale> getAllResource = service.getAll();

        return getAllResource;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Sale getOne(@PathParam("id") int id) throws Exception {

        SaleService service = new SaleService();
        Sale getOneResource = service.getOne(id);

        return getOneResource;
    }

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Sale update(@PathParam("id") int id, Sale sale) throws Exception {

        SaleService service = new SaleService();
        Sale updateResource = service.update(id, sale);

        return updateResource;
    }

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void delete(@PathParam("id") int id) throws Exception {

        SaleService service = new SaleService();
        service.delete(id);

    }
}
