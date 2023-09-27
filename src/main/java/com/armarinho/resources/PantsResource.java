package com.armarinho.resources;

import com.armarinho.models.Pants;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/pants")
public class PantsResource {

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Pants[] getAll() {

        Pants pants1 = new Pants();
        pants1.setName("Denim pants");
        pants1.setSize("M");
        pants1.setId(1);

        Pants pants2 = new Pants();
        pants1.setName("Skinny pants");
        pants1.setSize("G");
        pants1.setId(2);

        Pants pants3 = new Pants();
        pants1.setName("Flare pants");
        pants1.setSize("P");
        pants1.setId(3);

        Pants[] list = new Pants[3];
        list[0] = pants1;
        list[1] = pants2;
        list[2] = pants3;

        return list;
    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Pants getOne(@PathParam("id") int id) {

        Pants pants1 = new Pants();
        pants1.setName("Denim pants");
        pants1.setSize("M");
        pants1.setId(1);

        Pants pants2 = new Pants();
        pants1.setName("Skinny pants");
        pants1.setSize("G");
        pants1.setId(2);

        Pants pants3 = new Pants();
        pants1.setName("Flare pants");
        pants1.setSize("P");
        pants1.setId(3);

        Pants[] list = new Pants[3];
        list[0] = pants1;
        list[1] = pants2;
        list[2] = pants3;

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
    public Pants[] create(Pants pants) {

        Pants pants1 = new Pants();
        pants1.setName("Denim pants");
        pants1.setSize("M");
        pants1.setId(1);

        Pants pants2 = new Pants();
        pants1.setName("Skinny pants");
        pants1.setSize("G");
        pants1.setId(2);

        Pants pants3 = new Pants();
        pants1.setName("Flare pants");
        pants1.setSize("P");
        pants1.setId(3);

        Pants[] list = new Pants[3];
        list[0] = pants1;
        list[1] = pants2;
        list[2] = pants3;

        int compareId = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                if (compareId < list[i].getId()) {
                    compareId = list[i].getId();
                }
            }
        }

        pants.setId(compareId++);

        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                list[i] = pants;
                break;
            }
        }

        return null;
    }

    @PUT
    @Path("/{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Pants insert(@PathParam("id") long id, Pants pants) {

        Pants pants1 = new Pants();
        pants1.setName("Denim pants");
        pants1.setSize("M");
        pants1.setId(1);

        Pants pants2 = new Pants();
        pants1.setName("Skinny pants");
        pants1.setSize("G");
        pants1.setId(2);

        Pants pants3 = new Pants();
        pants1.setName("Flare pants");
        pants1.setSize("P");
        pants1.setId(3);

        Pants[] list = new Pants[3];
        list[0] = pants1;
        list[1] = pants2;
        list[2] = pants3;

        for (int i = 0; i < list.length; i++) {
            if (list[i].getId() == id) {
                list[i].setName(pants.getName());
                return list[i];
            }
        }

        return null;
    }

    @DELETE
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") long id) {

        Pants pants1 = new Pants();
        pants1.setName("Denim pants");
        pants1.setSize("M");
        pants1.setId(1);

        Pants pants2 = new Pants();
        pants1.setName("Skinny pants");
        pants1.setSize("G");
        pants1.setId(2);

        Pants pants3 = new Pants();
        pants1.setName("Flare pants");
        pants1.setSize("P");
        pants1.setId(3);

        Pants[] list = new Pants[3];
        list[0] = pants1;
        list[1] = pants2;
        list[2] = pants3;

        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                if (list[i].getId() == id) {
                    list[i] = null;
                }
            }
        }
    }

}