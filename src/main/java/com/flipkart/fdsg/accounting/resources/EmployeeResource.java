package com.flipkart.fdsg.accounting.resources;

import com.flipkart.fdsg.accounting.DTO.EmployeeDTO;
import com.flipkart.fdsg.accounting.entities.Employee;
import com.flipkart.fdsg.accounting.service.EmployeeService;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by amith.prasad on 25/10/18.
 */

@Path("/employees")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Path("/{id}")
    @GET
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeDTO getEmployee(@PathParam("id") Long id){

        Employee employee = employeeService.getEmployeeById(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        return employeeDTO;
    }
}
