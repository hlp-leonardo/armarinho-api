package com.armarinho.resources;

import com.armarinho.models.Dress;
import jakarta.ws.rs.*;
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
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Dress getOne(@PathParam("id") int id) {

        Dress dress1 = new Dress();
        dress1.setName("Vestido 1");
        dress1.setSize("M");
        dress1.setId(4);

        Dress dress2 = new Dress();
        dress2.setName("Vestido 2");
        dress2.setSize("G");
        dress2.setId(2);

        Dress dress3 = new Dress();
        dress3.setName("Vestido 3");
        dress3.setSize("P");
        dress3.setId(7);

        Dress[] list = new Dress[5];
        list[0] = dress1;
        list[1] = dress2;
        list[2] = dress3;

        for (int i = 0; i < list.length; i++) {
            if (list[i].getId() == id) {
                return list[i];
            }
        }

        return null;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Dress[] create(Dress dress) {

        Dress dress1 = new Dress();
        dress1.setName("Vestido 1");
        dress1.setSize("M");
        dress1.setId(4);

        Dress dress2 = new Dress();
        dress2.setName("Vestido 2");
        dress2.setSize("G");
        dress2.setId(2);

        Dress dress3 = new Dress();
        dress3.setName("Vestido 3");
        dress3.setSize("P");
        dress3.setId(7);

        Dress[] list = new Dress[5];
        list[0] = dress1;
        list[1] = dress2;
        list[2] = dress3;

        long compareId = 0;
        for (int i=0; i < list.length; i++) {
            if (list[i] != null) {
                if (compareId < list[i].getId()) {
                    compareId = list[i].getId();
                }
            }
        }

        dress.setId(compareId + 1);

        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                list[i] = dress;
                break;
            }
        }

        return list;
    }

    @PUT
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Dress update(@PathParam("id") long id, Dress dress) {

        Dress dress1 = new Dress();
        dress1.setName("Vestido 1");
        dress1.setSize("M");
        dress1.setId(4);

        Dress dress2 = new Dress();
        dress2.setName("Vestido 2");
        dress2.setSize("G");
        dress2.setId(2);

        Dress dress3 = new Dress();
        dress3.setName("Vestido 3");
        dress3.setSize("P");
        dress3.setId(7);

        Dress[] list = new Dress[5];
        list[0] = dress1;
        list[1] = dress2;
        list[2] = dress3;

        for (int i=0; i < list.length; i++) {
            if (list[i].getId() == id) {
                list[i].setName(dress.getName());
                return list[i];
            }
        }
        return null;
    }

    @DELETE
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") int id) {

        Dress dress1 = new Dress();
        dress1.setName("Vestido 1");
        dress1.setSize("M");
        dress1.setId(4);

        Dress dress2 = new Dress();
        dress2.setName("Vestido 2");
        dress2.setSize("G");
        dress2.setId(2);

        Dress dress3 = new Dress();
        dress3.setName("Vestido 3");
        dress3.setSize("P");
        dress3.setId(7);

        Dress[] list = new Dress[5];
        list[0] = dress1;
        list[1] = dress2;
        list[2] = dress3;

        for (int i=0; i< list.length; i++) {
            if (list[i] != null) {
                if (list[i].getId() == id) {
                    list[i] = null;
                }
            }
        }
    }
}
