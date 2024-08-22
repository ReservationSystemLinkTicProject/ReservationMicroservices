package com.linktic.microservice_services.persistence;

import com.linktic.microservice_services.entities.Service;
import org.springframework.data.repository.CrudRepository;

public interface IServiceRepository  extends CrudRepository<Service, Long> {
}
