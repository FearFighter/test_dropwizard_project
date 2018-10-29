package com.flipkart.fdsg.accounting.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by amith.prasad on 22/10/18.
 */
@Path("/")
public class DefaultResource {

//    @Path("/")
    @GET
    public String welcome(){
        return "Hello World";
    }

    @GET
    @Path("/2")
    public String welcome2(){
        return "Hello World 2";
    }
}
