/*
 * This file has the definition of the employee repositories in the application. 
 *
 * @author Catalina Ariza and Julian Celis
 */
package com.mycompany.javaservices.repositories;

import com.mycompany.javaservices.dataObjects.EmployeeDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositories {

    private final String PATH = "data/employees.json";
    private List<EmployeeDAO> employees = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.loadData();
    }

    /**
     * *
     * This method load the json employee data.
     */
    private void loadData() {
        employees.addAll(JSONOperations.loadData(PATH, EmployeeDAO.class));
    }

    /**
     * *
     * This method gets a employee based on the id.
     *
     * @param id
     * @return the user data.
     */
    public Optional<EmployeeDAO> getById(Integer id) {
        for (EmployeeDAO employee : this.employees) {
            if (employee.getEmployeeId() == id) {
                return Optional.of(employee);
            }
        }
        return Optional.empty();
    }

    /**
     * *
     * This method creates a new employee.
     *
     * @param employee
     * @return a new employee.
     */
    public Optional<EmployeeDAO> create(EmployeeDAO employee) {
        int lastId = 1;
        if (!this.employees.isEmpty()) {
            lastId = employees.get(employees.size() - 1).getEmployeeId();
            lastId++;
        }

        EmployeeDAO newEmployee = new EmployeeDAO(
                lastId,
                employee.getEmployeeName(),
                employee.getDescription(),
                employee.getShopId()
        );

        this.employees.add(newEmployee);
        JSONOperations.saveData(PATH, this.employees);
        return Optional.of(newEmployee);
    }

    /**
     * *
     * This method get employees by shop id.
     *
     * @param shopId
     * @return all employees by shop id.
     */
    public List<Optional<EmployeeDAO>> getEmployeesBtShopId(Integer shopId) {
        List<Optional<EmployeeDAO>> result = new ArrayList<>();
        for (EmployeeDAO employee : employees) {
            if (employee.getShopId() == shopId) {
                result.add(Optional.of(employee));
            }
        }
        return result;
    }

    /**
     * *
     * This method allows update employee name.
     *
     * @param employee
     * @return a employee updated
     */
    public Boolean updateEmployeeDescription(EmployeeDAO employee) {
        Boolean result = false;
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i).getEmployeeId() == employee.getEmployeeId()) {
                this.employees.get(i).setDescription(employee.getDescription());
                JSONOperations.saveData(PATH, this.employees);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * *
     * This method deletes an employee
     *
     * @param id
     * @return an employee deleted
     */
    public Boolean deleteEmployee(int id) {
        Boolean result = false;
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i).getEmployeeId() == id) {
                this.employees.remove(i);
                JSONOperations.saveData(PATH, this.employees);
                result = true;
                break;
            }
        }

        return result;
    }
}
