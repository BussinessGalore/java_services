/**
 * This file has a data object classs that represents the user data 
 * access object. 
 * 
 * @author Catalina Ariza and Julian Celis
 */
package com.mycompany.javaservices.dataObjects;

public class UserDAO {
    
    private int idUser;
    private String userName;
    private String phoneNumber;
    private String password;
    private String email;
    private boolean isManager;

    public UserDAO() {}
    
    public UserDAO(int idUser, String userName, String phoneNumber, String password, String email, boolean isManager) {
        this.idUser = idUser;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.email = email;
        this.isManager = isManager;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIsManager() {
        return isManager;
    }

    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }
    
    
}
