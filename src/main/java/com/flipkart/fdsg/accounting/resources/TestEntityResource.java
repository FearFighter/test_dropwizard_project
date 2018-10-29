package com.flipkart.fdsg.accounting.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.fdsg.accounting.entities.TestEntity;
import com.flipkart.fdsg.accounting.service.TestEntityAction;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.IOException;

/**
 * Created by amith.prasad on 24/10/18.
 */

@Path("/key")
public class TestEntityResource {

    private TestEntityAction testEntityAction;
    private ObjectMapper mapper = new ObjectMapper();

    public TestEntityResource() {
        testEntityAction = new TestEntityAction();
    }

    @Path("/get/{key}")
    @GET
    public String getDataByKey(@PathParam("key") String key) throws IOException {
        return testEntityAction.getDataByKey(key);
    }

    @Path("/update/{key}")
    @PUT
    public String updateDataByKey(@PathParam("key") String key, TestEntity newTestEntity) throws IOException {
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(testEntityAction.updateDataByKey(key,newTestEntity));
    }
}
