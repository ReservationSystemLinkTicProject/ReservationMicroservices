package com.linktic.microservice_services.controller;

import com.linktic.microservice_services.entities.Service;
import com.linktic.microservice_services.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/services")
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class ServiceController {
    @Autowired
    private IServiceService ServiceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveService(@RequestBody Service Service) {
        ServiceService.save(Service);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(ServiceService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ServiceService.findById(id));
    }
    
}
