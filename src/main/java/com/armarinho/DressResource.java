package com.armarinho;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/dress")
public class DressResource {

    @GET
    public String hello () {
        return "Hello World";
    }
}
