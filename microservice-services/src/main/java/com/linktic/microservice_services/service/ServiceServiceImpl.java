package com.linktic.microservice_services.service;

import com.linktic.microservice_services.exception.ServiceNotFoundException;
import com.linktic.microservice_services.persistence.IServiceRepository;
import com.linktic.microservice_services.entities.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService {

    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public List<Service> findAll() {
        return (List<Service>) serviceRepository.findAll();
    }

    @Override
    public Service findById(Long id) {
        return serviceRepository.findById(id).orElseThrow(() -> new ServiceNotFoundException(id));
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }
}
