package com.flipkart.fdsg.accounting.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.fdsg.accounting.entities.TestEntity;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by amith.prasad on 24/10/18.
 */
public class FileDAO implements GenericDAO{


    @Override
    public String getByKey(String key) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> testEntities = mapper.readValue(new File("/Users/amith.prasad/work/java_repos/testproject/src/main/java/com/flipkart/fdsg/accounting/TestEntityFile/test_entity_file.json"), HashMap.class);
        return testEntities.get(key).toString();
    }

    @Override
    public String updateByKey(String key,TestEntity testEntity) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Map<String,Object> testEntities = mapper.readValue(new File("/Users/amith.prasad/work/java_repos/testproject/src/main/java/com/flipkart/fdsg/accounting/TestEntityFile/test_entity_file.json"), HashMap.class);
        testEntities.put(key,testEntity);

        mapper.writeValue(new File("/Users/amith.prasad/work/java_repos/testproject/src/main/java/com/flipkart/fdsg/accounting/TestEntityFile/test_entity_file.json"), testEntities);
        return testEntities.get(key).toString();
    }
}
