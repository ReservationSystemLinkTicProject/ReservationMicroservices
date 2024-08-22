package com.linktic.microservice_services.service;

import com.linktic.microservice_services.entities.Service;

import java.util.List;

public interface IServiceService {
    List<Service> findAll();
    Service findById(Long id);
    void save(Service service);
}
