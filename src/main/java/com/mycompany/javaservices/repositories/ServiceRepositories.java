/*
 * This file has the definition of the service repositories in the application. 
 *
 * @author Catalina Ariza and Julian Celis
 */
package com.mycompany.javaservices.repositories;

import com.mycompany.javaservices.dataObjects.ServiceDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceRepositories {

    private final String PATH = "data/services.json";
    private List<ServiceDAO> services = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.loadData();
    }

    /**
     * *
     * This method load the json service data.
     */
    private void loadData() {
        services.addAll(JSONOperations.loadData(PATH, ServiceDAO.class));
    }

    /**
     * This method gets a service based on the id.
     *
     * @param id
     * @return The service data.
     */
    public Optional<ServiceDAO> getById(Integer id) {
        for (ServiceDAO service : this.services) {
            if (service.getServiceId() == id) {
                return Optional.of(service);
            }
        }
        return Optional.empty();
    }

    /**
     * *
     * This method creates a service.
     *
     * @param service
     * @return a new service.
     */
    public Optional<ServiceDAO> create(ServiceDAO service) {
        int lastId = 1;
        if (!this.services.isEmpty()) {
            lastId = services.get(services.size() - 1).getServiceId();
            lastId++;
        }

        ServiceDAO newService = new ServiceDAO(
                lastId,
                service.getShopId(),
                service.getServiceName(),
                service.getServicePrice()
        );

        this.services.add(newService);
        JSONOperations.saveData(PATH, this.services);
        return Optional.of(newService);
    }

    /**
     * *
     * The method get employees by shop id.
     *
     * @param shopId
     * @return employees by shop id.
     */
    public List<Optional<ServiceDAO>> getEmployeesByShopId(Integer shopId) {
        List<Optional<ServiceDAO>> result = new ArrayList<>();
        for (ServiceDAO service : services) {
            if (service.getShopId() == shopId) {
                result.add(Optional.of(service));
            }
        }
        return result;
    }

    /**
     * *
     * This method update the service price.
     *
     * @param service
     * @return the service price updated.
     */
    public Boolean updateServicePrice(ServiceDAO service) {
        Boolean result = false;
        for (int i = 0; i < this.services.size(); i++) {
            if (this.services.get(i).getServiceId() == service.getServiceId()) {
                this.services.get(i).setServicePrice(service.getServicePrice());
                JSONOperations.saveData(PATH, this.services);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * *
     * This method deletes a service by id.
     *
     * @param id
     * @return a boolean response.
     */
    public Boolean deleteService(int id) {
        Boolean result = false;
        for (int i = 0; i < this.services.size(); i++) {
            if (this.services.get(i).getServiceId() == id) {
                this.services.remove(i);
                JSONOperations.saveData(PATH, this.services);
                result = true;
                break;
            }
        }

        return result;
    }
}
