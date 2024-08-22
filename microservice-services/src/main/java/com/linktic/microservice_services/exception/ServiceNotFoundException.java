package com.linktic.microservice_services.exception;

public class ServiceNotFoundException extends RuntimeException {
    public ServiceNotFoundException(Long serviceId) {
        super("Service with id: " + serviceId + " not found");
    }
}
