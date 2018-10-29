package com.flipkart.fdsg.accounting.dao;

import com.flipkart.fdsg.accounting.entities.TestEntity;

import java.util.Map;

/**
 * Created by amith.prasad on 24/10/18.
 */
public class HashMapDAO implements GenericDAO{

    public static Map<String,TestEntity> testEntities;

    public static void setTestEntities(Map<String, TestEntity> testEntities) {
        HashMapDAO.testEntities = testEntities;
    }

    @Override
    public String getByKey(String key) {
        return testEntities.get(key).toString();
    }

    @Override
    public String updateByKey(String key, TestEntity testEntity) {
        testEntities.put(key,testEntity);
        return testEntities.toString();
    }
}
