package com.armarinho.resources;

import com.armarinho.models.Dress;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/dress")
public class DressResource {

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Dress[] getAll() {
        Dress dress1 = new Dress();
        dress1.setName("Vestido 1");
        dress1.setSize("M");
        dress1.setId(1);

        Dress dress2 = new Dress();
        dress2.setName("Vestido 2");
        dress2.setSize("G");
        dress2.setId(2);

        Dress dress3 = new Dress();
        dress3.setName("Vestido 3");
        dress3.setSize("P");
        dress3.setId(3);

        Dress[] list = new Dress[5];
        list[0] = dress1;
        list[1] = dress2;
        list[2] = dress3;
        return list;
    }

    @GET
    @Path("/{id}")
    public Dress[] getOne(@PathParam("id") int id) {
        Dress dress1 = new Dress();
        dress1.setName("Vestido 1");
        dress1.setSize("M");
        dress1.setId(1);

        Dress dress2 = new Dress();
        dress2.setName("Vestido 2");
        dress2.setSize("G");
        dress2.setId(2);

        Dress dress3 = new Dress();
        dress3.setName("Vestido 3");
        dress3.setSize("P");
        dress3.setId(3);

        Dress[] list = new Dress[5];
        list[0] = dress1;
        list[1] = dress2;
        list[2] = dress3;
        return list;
    }

    public String create() {
        return null;
    }
}
