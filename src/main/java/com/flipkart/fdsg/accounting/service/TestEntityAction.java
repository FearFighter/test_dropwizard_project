package com.flipkart.fdsg.accounting.service;

import com.flipkart.fdsg.accounting.dao.FileDAO;
import com.flipkart.fdsg.accounting.dao.GenericDAO;
import com.flipkart.fdsg.accounting.entities.TestEntity;

import java.io.IOException;

/**
 * Created by amith.prasad on 24/10/18.
 */
public class TestEntityAction {

    private GenericDAO genericDAO;

    public TestEntityAction() {
//        genericDAO = new HashMapDAO();
        genericDAO = new FileDAO();
    }

    public String getDataByKey(String key) throws IOException {

        return genericDAO.getByKey(key);
    }

    public String updateDataByKey(String key, TestEntity newTestEntity) throws IOException {

        return genericDAO.updateByKey(key,newTestEntity);
    }
}
