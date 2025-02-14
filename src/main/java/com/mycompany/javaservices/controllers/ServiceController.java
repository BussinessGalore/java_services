/*
 * This file has the definition of the services endpoints in the application.
 *
 * @author Catalina Ariza and Julian Celis
 */
package com.mycompany.javaservices.controllers;

import com.mycompany.javaservices.dataObjects.ServiceDAO;
import com.mycompany.javaservices.services.ServiceServices;
import java.util.List;
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
@RequestMapping("v1/services")
public class ServiceController {

    @Autowired
    private ServiceServices serviceServices;

    /**
     * *
     * This method get a service by id.
     *
     * @param id
     * @return a service created.
     */
    @GetMapping("/get_by_id/{serviceId}")
    public Optional<ServiceDAO> getById(@PathVariable("serviceId") Integer id) {
        return serviceServices.getById(id);
    }

    /**
     * This method creates a new service.
     *
     * @param service
     * @return The service created.
     */
    @PostMapping("/create")
    public Optional<ServiceDAO> create(@RequestBody ServiceDAO service) {
        return serviceServices.create(service);
    }

    /**
     * *
     * This method gets a service by shop id.
     *
     * @param id
     * @return a service by shop id.
     */
    @PostMapping("/get_services_by_shopId/{shopId}")
    public List<Optional<ServiceDAO>> getShopEmployees(@PathVariable("shopId") Integer id) {
        return serviceServices.getServicesByShopId(id);
    }

    /**
     * *
     * This method updates the service price.
     *
     * @param service
     * @return the service updated.
     */
    @PatchMapping("/update_servicePrice")
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean updateServicePrice(@RequestBody ServiceDAO service) {
        return serviceServices.updateServicePrice(service);
    }

    /**
     * *
     * This method deletes a service.
     *
     * @param id
     * @return a service deleted.
     */
    @DeleteMapping("/delete_service/{serviceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteService(@PathVariable("serviceId") Integer id) {
        return serviceServices.deleteService(id);
    }

}
