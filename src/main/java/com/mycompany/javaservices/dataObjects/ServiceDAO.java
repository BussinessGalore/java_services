/**
 * This file has a data object classs that represents the service data 
 * access object. 
 * 
 * @author Catalina Ariza and Julian Celis
 */
package com.mycompany.javaservices.dataObjects;

public class ServiceDAO {
    
    private int serviceId;
    private int shopId;
    private String serviceName;
    private double servicePrice;
    
    public ServiceDAO() {}

    public ServiceDAO(int serviceId, int shopId, String serviceName, double servicePrice) {
        this.serviceId = serviceId;
        this.shopId = shopId;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }
    
    
    
    
}
