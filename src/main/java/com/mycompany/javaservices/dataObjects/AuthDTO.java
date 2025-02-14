/**
 * This file has a data object class that represents the authentication
 * data transfer object.
 * 
 * @authors Catalina Ariza and Julian Celis
 */

package com.mycompany.javaservices.dataObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthDTO {
    
    private String password = null;
    private String email = null; 
    
    @JsonCreator
    public AuthDTO(@JsonProperty("email") String email, @JsonProperty("password") String password) {
        this.email = email;
        this.password = password;
    }
    
    /**
    *  This method returns the password.
    * 
    * @return The password.
    */
    public String getPassword() {
        return password;
    }

    /**
    *  This method returns the email.
    * 
    * @return The email.
    */    
    public String getEmail() {
        return email;
    }
            
}
