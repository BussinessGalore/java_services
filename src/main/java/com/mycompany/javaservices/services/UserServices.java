/*
 * This file has the definition of the bussiness logic to handle users.
 * 
 * @author Catalina Ariza and Julian Celis
 */
package com.mycompany.javaservices.services;

import com.mycompany.javaservices.dataObjects.AuthDTO;
import com.mycompany.javaservices.dataObjects.UserDAO;
import com.mycompany.javaservices.repositories.UserRepositories;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServices {
    
    @Autowired
    public UserRepositories userRepositories;
     /***
      * This method returns a user by its id.
      * @param id
      * @return The user found.
      */
    public Optional<UserDAO> getById(Integer id){
        if(id < 0){ // Negative ids cannot exists.
            return Optional.empty();            
        }else{
            return userRepositories.getById(id);
        }
    }
    /***
     * This method authenticates a user.
     * @param authData
     * @return The user authenticated.
     */
    public Optional<UserDAO> login(AuthDTO authData){
        if(authData.getPassword() == null || authData.getEmail() == null){
            return Optional.empty();
        }else{
            return userRepositories.login(authData);
        }
    }
    
    /***
     * This method validates if all user fields are valid.
     * @param user
     * @return The user created.
     */
    public Optional<UserDAO> create(UserDAO user){
        if (user.getUserName() == null || user.getEmail() == null || user.getPassword() == null
            || user.getPhoneNumber() == null){
            return null;
        } else {
            return userRepositories.create(user);
        }        
    }
    
    /**
     * This method is used to update the password of a user.
     *
     * @param user
     * @return A boolean value to indicate if the password was updated.
     */
    public Boolean updatePassword(UserDAO user) {
        if (user.getIdUser()  < 0 || user.getPassword() == null) {
            return false;
        }
        return userRepositories.updatePassword(user);
    }

    /**
     * This method is used to delete a user by the id.
     *
     * @param id
     * @return A boolean value to indicate if the user was deleted.
     */
    public Boolean deleteUser(Integer id) {
        if (id < 0) {
            return false;
        }
        return userRepositories.deleteUser(id);
    }
}
