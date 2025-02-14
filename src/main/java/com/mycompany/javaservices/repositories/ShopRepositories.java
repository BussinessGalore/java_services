/*
 * This file has the definition of the shop repositories in the application. 
 *
 * @author Catalina Ariza and Julian Celis
 */
package com.mycompany.javaservices.repositories;

import com.mycompany.javaservices.dataObjects.ShopDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class ShopRepositories {

    private final String PATH = "data/shops.json";
    private List<ShopDAO> shops = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.loadData();
    }

    /**
     * *
     * This method load the json shop data.
     */
    private void loadData() {
        shops.addAll(JSONOperations.loadData(PATH, ShopDAO.class));
    }

    /**
     * *
     * This method gets a shop based on the id.
     *
     * @param id
     * @return a shop.
     */
    public Optional<ShopDAO> getById(Integer id) {
        for (ShopDAO shop : this.shops) {
            if (shop.getShopId() == id) {
                return Optional.of(shop);
            }
        }
        return Optional.empty();
    }

    /**
     * *
     * This method creates a new shop.
     *
     * @param shop
     * @return a new shop.
     */
    public Optional<ShopDAO> create(ShopDAO shop) {
        int lastId = 1;
        if (!this.shops.isEmpty()) {
            lastId = shops.get(shops.size() - 1).getShopId();
            lastId++;
        }

        ShopDAO newShop = new ShopDAO(
                lastId,
                shop.getShopName(),
                shop.getManagerId(),
                shop.getShopPhoneNumber(),
                shop.getAdress(),
                shop.getOpeningTime(),
                shop.getClosingTime(),
                shop.getProfit()
        );

        this.shops.add(newShop);
        JSONOperations.saveData(PATH, this.shops);
        return Optional.of(newShop);
    }

    /**
     * *
     * This method allows to update the shop
     *
     * @param shop
     * @return a shop updated
     */
    public Boolean updateShop(ShopDAO shop) {
        Boolean result = false;
        for (int i = 0; i < this.shops.size(); i++) {
            if (this.shops.get(i).getShopId() == shop.getShopId()) {
                this.shops.get(i).setShopName(shop.getShopName());
                this.shops.get(i).setShopPhoneNumber(shop.getShopPhoneNumber());
                this.shops.get(i).setAdress(shop.getAdress());
                this.shops.get(i).setOpeningTime(shop.getOpeningTime());
                this.shops.get(i).setClosingTime(shop.getClosingTime());
                this.shops.get(i).setProfit(shop.getProfit());
                JSONOperations.saveData(PATH, this.shops);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * *
     * This method allows to delete a shop
     *
     * @param id
     * @return boolean result
     */
    public Boolean deleteShop(int id) {
        Boolean result = false;
        for (int i = 0; i < this.shops.size(); i++) {
            if (this.shops.get(i).getShopId() == id) {
                this.shops.remove(i);
                JSONOperations.saveData(PATH, this.shops);
                result = true;
                break;
            }
        }

        return result;
    }
}
