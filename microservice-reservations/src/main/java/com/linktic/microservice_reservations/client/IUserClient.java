package com.linktic.microservice_reservations.client;

import com.linktic.microservice_reservations.config.FeignConfig;
import com.linktic.microservice_reservations.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-users", url = "http://localhost:8080/api/users", configuration = FeignConfig.class)
public interface IUserClient {
    @GetMapping("/{id}")
    UserDto findById(@PathVariable Long id);
}
