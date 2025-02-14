/**
 * This file has a data object classs that represents the shop data 
 * access object. 
 * 
 * @author Catalina Ariza and Julian Celis
 */
package com.mycompany.javaservices.dataObjects;

import java.util.Date;

public class ShopDAO {
    
    private int shopId;
    private String shopName;
    private int managerId;
    private String shopPhoneNumber;
    private String adress;
    private Date openingTime;
    private Date closingTime;    
    private double profit;   
    
    public ShopDAO() {}

    public ShopDAO(int shopId, String shopName, int managerId, String shopPhoneNumber, String adress, Date openingTime, Date closingTime, double profit) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.managerId = managerId;
        this.shopPhoneNumber = shopPhoneNumber;
        this.adress = adress;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.profit = profit;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getShopPhoneNumber() {
        return shopPhoneNumber;
    }

    public void setShopPhoneNumber(String shopPhoneNumber) {
        this.shopPhoneNumber = shopPhoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Date openingTime) {
        this.openingTime = openingTime;
    }

    public Date getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Date closingTime) {
        this.closingTime = closingTime;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
