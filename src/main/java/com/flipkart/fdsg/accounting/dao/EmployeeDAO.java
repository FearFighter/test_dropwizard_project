package com.flipkart.fdsg.accounting.dao;

import com.flipkart.fdsg.accounting.entities.Employee;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

/**
 * Created by amith.prasad on 25/10/18.
 */
public class EmployeeDAO extends AbstractDAO<Employee> {

    public SessionFactory sessionFactory;

    public EmployeeDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Employee findById(Long id) {
            return super.get(id);
    }
}
