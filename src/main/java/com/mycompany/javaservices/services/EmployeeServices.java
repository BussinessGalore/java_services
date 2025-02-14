/*
 * This file has the definition of the bussiness logic to handle employees.
 * 
 * @author Catalina Ariza and Julian Celis
 */
package com.mycompany.javaservices.services;

import com.mycompany.javaservices.dataObjects.EmployeeDAO;
import com.mycompany.javaservices.repositories.EmployeeRepositories;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServices {

    @Autowired
    public EmployeeRepositories employeeRepositories;

    /**
     * *
     * The method returns a employee by its id.
     *
     * @param id
     * @return The employee found.
     */
    public Optional<EmployeeDAO> getById(Integer id) {
        if (id < 0) { // Negative ids cannot exists.
            return Optional.empty();
        } else {
            return employeeRepositories.getById(id);
        }
    }

    /**
     * *
     * The method validate is all employees fields .
     *
     * @param employee
     * @return The employee created.
     */
    public Optional<EmployeeDAO> create(EmployeeDAO employee) {
        if (employee.getEmployeeName() == null || employee.getDescription() == null
                || employee.getShopId() < 0) {
            return null;
        } else {
            return employeeRepositories.create(employee);
        }
    }

    /**
     * *
     * This method gets an employee by shop id.
     *
     * @param shopId
     * @return a employee by shop id.
     */
    public List<Optional<EmployeeDAO>> getEmployeesBtShopId(Integer shopId) {
        if (shopId < 0) {
            return new ArrayList<>();
        } else {
            return employeeRepositories.getEmployeesBtShopId(shopId);
        }
    }

    /**
     * *
     * This method updates a description employee.
     *
     * @param employee
     * @return a new description for the employee.
     */
    public Boolean updateEmployeeDescription(EmployeeDAO employee) {
        if (employee.getEmployeeId() < 0 || employee.getDescription() == null) {
            return false;
        }
        return employeeRepositories.updateEmployeeDescription(employee);
    }

    /**
     * *
     * Thid method deletes an employee.
     *
     * @param id
     * @return an employee deleted.
     */
    public Boolean deleteEmployee(Integer id) {
        if (id < 0) {
            return false;
        }
        return employeeRepositories.deleteEmployee(id);
    }

}
