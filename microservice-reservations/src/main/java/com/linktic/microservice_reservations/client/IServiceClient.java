package com.linktic.microservice_reservations.client;

import com.linktic.microservice_reservations.config.FeignConfig;
import com.linktic.microservice_reservations.dto.ServiceDto;
import com.linktic.microservice_reservations.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-services", url = "http://localhost:8092/api/services", configuration = FeignConfig.class)
public interface IServiceClient {
    @GetMapping("/{id}")
    ServiceDto findById(@PathVariable Long id);
}
