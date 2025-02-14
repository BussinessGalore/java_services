/*
 * This file has the definition of the shop endpoints in the application.
 *
 * @author Catalina Ariza and Julian Celis
 */
package com.mycompany.javaservices.controllers;

import com.mycompany.javaservices.dataObjects.ShopDAO;
import com.mycompany.javaservices.services.ShopServices;
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
@RequestMapping("v1/shops")
public class ShopController {

    @Autowired
    private ShopServices shopServices;

    /**
     * *
     * This method get a shop by id.
     *
     * @param id
     * @return a user created.
     */
    @GetMapping("/get_by_id/{shopId}")
    public Optional<ShopDAO> getById(@PathVariable("shopId") Integer id) {
        return shopServices.getById(id);
    }

    /**
     * This method creates a new shop.
     *
     * @param shop
     * @return The shop created.
     */
    @PostMapping("/create")
    public Optional<ShopDAO> create(@RequestBody ShopDAO shop) {
        return shopServices.create(shop);
    }

    /**
     * *
     * This method allows to update the shop.
     *
     * @param shop
     * @return a boolean result
     */
    @PatchMapping("/update_shop")
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean updateShop(@RequestBody ShopDAO shop) {
        return shopServices.updateShop(shop);
    }

    /**
     * *
     * This method deletes a shop.
     *
     * @param id
     * @return a delete shop.
     */
    @DeleteMapping("/delete_shop/{shopId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteShop(@PathVariable("shopId") Integer id) {
        return shopServices.deleteShop(id);
    }
}
