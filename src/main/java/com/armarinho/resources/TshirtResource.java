package com.armarinho.resources;

import com.armarinho.models.Dress;
import com.armarinho.models.Tshirt;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/tshirt")
public class TshirtResource {

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Tshirt[] getAll() {

        Tshirt tshirt1 = new Tshirt();
        tshirt1.setName("T-shirt 1");
        tshirt1.setSize("P");
        tshirt1.setId(1);

        Tshirt tshirt2 = new Tshirt();
        tshirt2.setName("T-shirt 2");
        tshirt2.setSize("M");
        tshirt2.setId(2);

        Tshirt[] list = new Tshirt[2];
        list[0] = tshirt1;
        list[1] = tshirt2;

        return list;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Tshirt[] getOne() {

        Tshirt tshirt1 = new Tshirt();
        tshirt1.setName("T-shirt 1");
        tshirt1.setSize("P");
        tshirt1.setId(1);

        Tshirt tshirt2 = new Tshirt();
        tshirt2.setName("T-shirt 2");
        tshirt2.setSize("M");
        tshirt2.setId(2);

        Tshirt[] list = new Tshirt[2];
        list[0] = tshirt1;
        list[1] = tshirt2;

        return list;


    }

}
