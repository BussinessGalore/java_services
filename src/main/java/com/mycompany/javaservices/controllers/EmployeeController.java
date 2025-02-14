/*
 * This file has the definition of the employee endpoints in the application.
 *
 * @author Catalina Ariza and Julian Celis
 */
package com.mycompany.javaservices.controllers;

import com.mycompany.javaservices.dataObjects.EmployeeDAO;
import com.mycompany.javaservices.services.EmployeeServices;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    /**
     * *
     * This method get a employee id.
     *
     * @param id
     * @return a employee created.
     */
    @GetMapping("/get_by_id/{employeeId}")
    public Optional<EmployeeDAO> getById(@PathVariable("employeeId") Integer id) {
        return employeeServices.getById(id);
    }

    /**
     * *
     * This method creates a new employee
     *
     * @param employee
     * @return the employee created.
     */
    @PostMapping("/create")
    public Optional<EmployeeDAO> create(@RequestBody EmployeeDAO employee) {
        return employeeServices.create(employee);
    }

    /**
     * *
     * This method get employess by shop id.
     *
     * @param id
     * @return all employees by shop id.
     */
    @PostMapping("/get_employees_by_shopId/{shopId}")
    public List<Optional<EmployeeDAO>> getShopEmployees(@PathVariable("shopId") Integer id) {
        return employeeServices.getEmployeesBtShopId(id);
    }

    /**
     * *
     * This method updates the name employee.
     *
     * @param employee
     * @return a employee updated.
     */
    @PatchMapping("/update_employeeName")
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean updateEmployeeDescription(@RequestBody EmployeeDAO employee) {
        return employeeServices.updateEmployeeDescription(employee);
    }

    /**
     * *
     * This method deletes an employee.
     *
     * @param id
     * @return an employee deleted.
     */
    @DeleteMapping("/delete_employee/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteEmployee(@PathVariable("employeeId") Integer id) {
        return employeeServices.deleteEmployee(id);
    }
}
