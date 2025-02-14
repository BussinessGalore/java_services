/**
 * This file has a data object classs that represents the employeee data 
 * access object. 
 * 
 * @author Catalina Ariza and Julian Celis
 */
package com.mycompany.javaservices.dataObjects;

public class EmployeeDAO {
    
    private int employeeId;    
    private String employeeName;
    private String description;
    private int shopId;
    
    public EmployeeDAO() {}

    public EmployeeDAO(int employeeId, String employeeName, String description, int shopId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.description = description;
        this.shopId = shopId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }    
    
    
}
