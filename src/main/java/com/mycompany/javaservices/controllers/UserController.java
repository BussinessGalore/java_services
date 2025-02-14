/*
 * This file has the definition of the user endpoints in the application.
 *
 * @author Catalina Ariza and Julian Celis
 */
package com.mycompany.javaservices.controllers;

import com.mycompany.javaservices.dataObjects.AuthDTO;
import com.mycompany.javaservices.dataObjects.UserDAO;
import java.util.Optional;
import com.mycompany.javaservices.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    /**
     * *
     * This method get a user by id.
     *
     * @param id
     * @return a user created.
     */
    @GetMapping("/get_by_id/{idUser}")
    public Optional<UserDAO> getById(@PathVariable("idUser") Integer id) {
        return userServices.getById(id);
    }

    /**
     * *
     * This method authenticate a user.
     *
     * @param authData
     * @return The user authenticated.
     */
    @PostMapping("/login")
    public Optional<UserDAO> login(@RequestBody AuthDTO authData) {
        return userServices.login(authData);
    }

    /**
     * This method creates a new user.
     *
     * @param user
     * @return The user created.
     */
    @PostMapping("/create")
    public Optional<UserDAO> create(@RequestBody UserDAO user) {
        return userServices.create(user);
    }

    /**
     * This service is used to update the password of a user.
     *
     * @param user
     * @return A boolean value to indicate if the password was updated.
     */
    @PatchMapping("/update_password")
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean updatePassword(@RequestBody UserDAO user) {
        return userServices.updatePassword(user);
    }

    /**
     * This service is used to delete a user by the id.
     *
     * @param id
     * @return A boolean value to indicate if the user was deleted.
     */
    @DeleteMapping("/delete_user/{idUser}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteUser(@PathVariable("idUser") Integer id) {
        return userServices.deleteUser(id);
    }
}
