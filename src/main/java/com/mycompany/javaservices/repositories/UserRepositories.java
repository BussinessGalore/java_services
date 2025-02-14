/*
 * This file has the definition of the user repositories in the application. 
 *
 * @author Catalina Ariza and Julian Celis
 */
package com.mycompany.javaservices.repositories;

import com.mycompany.javaservices.dataObjects.AuthDTO;
import com.mycompany.javaservices.dataObjects.UserDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositories {

    private final String PATH = "data/users.json";
    private List<UserDAO> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.loadData();
    }

    /**
     * *
     * This method load the json user data.
     */
    private void loadData() {
        users.addAll(JSONOperations.loadData(PATH, UserDAO.class));
    }

    /**
     * This method gets a user based on the id.
     *
     * @param id
     * @return The user data.
     */
    public Optional<UserDAO> getById(Integer id) {
        for (UserDAO user : this.users) {
            if (user.getIdUser() == id) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    /**
     * *
     * This method authenticates a user by email and password.
     *
     * @param authDTO
     * @return shows the user validated, if there are one.
     */
    public Optional<UserDAO> login(AuthDTO authDTO) {
        for (UserDAO user : this.users) {
            if (user.getEmail().equals(authDTO.getEmail())
                    && user.getPassword().equals(authDTO.getPassword())) {
                return Optional.of(user);
            }
        }

        return Optional.empty();
    }

    /**
     * *
     * This method creates a user.
     *
     * @param user
     * @return a new user.
     */
    public Optional<UserDAO> create(UserDAO user) {
        int lastId = 1;
        if (!this.users.isEmpty()) {
            lastId = users.get(users.size() - 1).getIdUser();
            lastId++;
        }

        UserDAO newUser = new UserDAO(
                lastId,
                user.getUserName(),
                user.getPhoneNumber(),
                user.getPassword(),
                user.getEmail(),
                user.isIsManager()
        );

        this.users.add(newUser);
        JSONOperations.saveData(PATH, this.users);
        return Optional.of(newUser);
    }

    /**
     * This method is used to update the password of a user.
     *
     * @param user
     * @return A boolean value to indicate if the password was updated.
     */
    public Boolean updatePassword(UserDAO user) {
        Boolean result = false;
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getIdUser() == user.getIdUser()) {
                this.users.get(i).setPassword(user.getPassword());
                JSONOperations.saveData(PATH, this.users);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * This method is used to delete a user by the id.
     *
     * @param id
     * @return A boolean value to indicate if the user was deleted.
     */
    public Boolean deleteUser(int id) {
        Boolean result = false;
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getIdUser() == id) {
                this.users.remove(i);
                JSONOperations.saveData(PATH, this.users);
                result = true;
                break;
            }
        }

        return result;
    }
}
