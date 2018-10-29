package com.flipkart.fdsg.accounting.dao;

import com.flipkart.fdsg.accounting.entities.TestEntity;

import java.io.IOException;

/**
 * Created by amith.prasad on 24/10/18.
 */
public interface GenericDAO {

    public String getByKey(String key) throws IOException;
    public String updateByKey(String key, TestEntity testEntity) throws IOException;
}
