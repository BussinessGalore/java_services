/*
 * This file has the definition of the bussiness logic to handle shops.
 * 
 * @author Catalina Ariza and Julian Celis
 */
package com.mycompany.javaservices.services;

import com.mycompany.javaservices.dataObjects.ShopDAO;
import com.mycompany.javaservices.repositories.ShopRepositories;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServices {

    @Autowired
    public ShopRepositories shopRepositories;

    /**
     * *
     * This method returns a shop by its id.
     *
     * @param id
     * @return The shop found.
     */
    public Optional<ShopDAO> getById(Integer id) {
        if (id < 0) { // Negative ids cannot exists.
            return Optional.empty();
        } else {
            return shopRepositories.getById(id);
        }
    }

    /**
     * *
     * This method validates is all shop fields are valid.
     *
     * @param shop
     * @return The shop created
     */
    public Optional<ShopDAO> create(ShopDAO shop) {
        if (shop.getShopName() == null || shop.getManagerId() < 0
                || shop.getShopPhoneNumber() == null
                || shop.getAdress() == null || shop.getOpeningTime() == null
                || shop.getProfit() < 0 || shop.getClosingTime() == null) {
            return null;
        } else {
            return shopRepositories.create(shop);
        }
    }

    /**
     * *
     * This method updates a shop
     *
     * @param shop
     * @return a shop updated.
     */
    public Boolean updateShop(ShopDAO shop) {
        if (shop.getShopId() < 0 || shop.getShopName() == null
                || shop.getShopPhoneNumber() == null
                || shop.getAdress() == null || shop.getOpeningTime() == null
                || shop.getProfit() < 0 || shop.getClosingTime() == null) {
            return false;
        }
        return shopRepositories.updateShop(shop);
    }

    /**
     * *
     * This method delete a shop.
     *
     * @param id
     * @return a shop deleted.
     */
    public Boolean deleteShop(Integer id) {
        if (id < 0) {
            return false;
        }
        return shopRepositories.deleteShop(id);

    }
}
