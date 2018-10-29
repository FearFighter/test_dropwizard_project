package com.flipkart.fdsg.accounting.setup;

import com.flipkart.fdsg.accounting.dao.HashMapDAO;
import com.flipkart.fdsg.accounting.entities.TestEntity;
import io.dropwizard.lifecycle.Managed;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amith.prasad on 24/10/18.
 */
public class PopulateTestEntityManaged implements Managed {

    @Override
    public void start() throws Exception {

        initializeHashMap();
        initializeFile();


    }

    private void initializeFile() {

    }

    private void initializeHashMap() {
        TestEntity testEntity1 = new TestEntity();
        testEntity1.setId("1");
        testEntity1.setName("Jackson");

        TestEntity testEntity2 = new TestEntity();
        testEntity2.setId("2");
        testEntity2.setName("Jersey");

        TestEntity testEntity3 = new TestEntity();
        testEntity3.setId("3");
        testEntity3.setName("Jetty");

        Map<String, TestEntity> testEntityMap = new HashMap();
        testEntityMap.put("key1",testEntity1);
        testEntityMap.put("key2",testEntity2);
        testEntityMap.put("key3",testEntity3);

        HashMapDAO.setTestEntities(testEntityMap);
    }

    @Override
    public void stop() throws Exception {

    }
}
