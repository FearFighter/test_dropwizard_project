package com.flipkart.fdsg.accounting.service;

import com.flipkart.fdsg.accounting.dao.EmployeeDAO;
import com.flipkart.fdsg.accounting.entities.Employee;

/**
 * Created by amith.prasad on 25/10/18.
 */
public class EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public Employee getEmployeeById(Long id){
        return employeeDAO.findById(id);
    }
}
