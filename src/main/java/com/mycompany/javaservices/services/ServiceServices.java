/*
 * This file has the definition of the bussiness logic to handle service.
 * 
 * @author Catalina Ariza and Julian Celis
 */
package com.mycompany.javaservices.services;

import com.mycompany.javaservices.dataObjects.ServiceDAO;
import com.mycompany.javaservices.repositories.ServiceRepositories;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceServices {

    @Autowired
    public ServiceRepositories serviceRepositories;

    /**
     * *
     * This method returns a service by its id.
     *
     * @param id
     * @return The service found.
     */
    public Optional<ServiceDAO> getById(Integer id) {
        if (id < 0) { // Negative ids cannot exists.
            return Optional.empty();
        } else {
            return serviceRepositories.getById(id);
        }
    }

    /**
     * *
     * This method validates if all services fields.
     *
     * @param service
     * @return The service created.
     */
    //se debe poner el id de la tienda?
    public Optional<ServiceDAO> create(ServiceDAO service) {
        if (service.getShopId() < 0 || service.getServiceName() == null
                || service.getServicePrice() < 0) {
            return null;
        } else {
            return serviceRepositories.create(service);
        }
    }

    /**
     * *
     * This method gets services by id shop.
     *
     * @param shopId
     * @return services by id shop.
     */

    public List<Optional<ServiceDAO>> getServicesByShopId(Integer shopId) {
        if (shopId < 0) {
            return new ArrayList<>();
        } else {
            return serviceRepositories.getEmployeesByShopId(shopId);
        }
    }

    /**
     * *
     * This method updates the price service.
     *
     * @param service
     * @return the service price updated.
     */
    public Boolean updateServicePrice(ServiceDAO service) {
        if (service.getServiceId() < 0 || service.getServicePrice() < 0) {
            return false;
        }
        return serviceRepositories.updateServicePrice(service);
    }

    public Boolean deleteService(Integer id) {
        if (id < 0) {
            return false;
        }
        return serviceRepositories.deleteService(id);
    }
}
