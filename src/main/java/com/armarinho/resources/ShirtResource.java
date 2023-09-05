package com.armarinho.resources;

import com.armarinho.models.Shirt;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/shirt")
public class ShirtResource {

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Shirt[] getAll() {

        Shirt shirt1 = new Shirt();
        shirt1.setName("T-shirt");
        shirt1.setSize("P");
        shirt1.setId(1);

        Shirt shirt2 = new Shirt();
        shirt2.setName("Cropped top");
        shirt2.setSize("M");
        shirt2.setId(2);

        Shirt[] list = new Shirt[5];
        list[0] = shirt1;
        list[1] = shirt2;

        return list;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Shirt getOne(@PathParam("id") int id) {

        Shirt shirt1 = new Shirt();
        shirt1.setName("T-shirt");
        shirt1.setSize("P");
        shirt1.setId(1);

        Shirt shirt2 = new Shirt();
        shirt2.setName("Cropped top");
        shirt2.setSize("M");
        shirt2.setId(2);

        Shirt[] list = new Shirt[5];
        list[0] = shirt1;
        list[1] = shirt2;

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
    public Shirt[] create(Shirt shirt) {

        Shirt shirt1 = new Shirt();
        shirt1.setName("T-shirt");
        shirt1.setSize("P");
        shirt1.setId(1);

        Shirt shirt2 = new Shirt();
        shirt2.setName("Cropped top");
        shirt2.setSize("M");
        shirt2.setId(2);

        Shirt[] list = new Shirt[5];
        list[0] = shirt1;
        list[1] = shirt2;

        long compareId = 0;
        for (int i=0; i < list.length; i++) {
            if (list[i] != null) {
                if (compareId < list[i].getId()) {
                    compareId = list[i].getId();
                }
            }
        }

        shirt.setId(compareId + 1);

        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                list[i] = shirt;
                break;
            }
        }

        return list;
    }

    @PUT
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Shirt update(@PathParam("id") long id, Shirt shirt) {

        Shirt shirt1 = new Shirt();
        shirt1.setName("T-shirt");
        shirt1.setSize("P");
        shirt1.setId(1);

        Shirt shirt2 = new Shirt();
        shirt2.setName("Cropped top");
        shirt2.setSize("M");
        shirt2.setId(2);

        Shirt[] list = new Shirt[5];
        list[0] = shirt1;
        list[1] = shirt2;

        for (int i=0; i < list.length; i++) {
            if (list[i].getId() == id) {
                list[i].setName(shirt.getName());
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

        Shirt shirt1 = new Shirt();
        shirt1.setName("T-shirt");
        shirt1.setSize("P");
        shirt1.setId(1);

        Shirt shirt2 = new Shirt();
        shirt2.setName("Cropped top");
        shirt2.setSize("M");
        shirt2.setId(2);

        Shirt[] list = new Shirt[5];
        list[0] = shirt1;
        list[1] = shirt2;

        for (int i=0; i< list.length; i++) {
            if (list[i] != null) {
                if (list[i].getId() == id) {
                    list[i] = null;
                }
            }
        }
    }

}
