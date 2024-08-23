package com.linktic.microservice_user.controllers;

import com.linktic.microservice_user.entities.User;
import com.linktic.microservice_user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class UserControllers {
    @Autowired
    private IUserService UserService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody User User) {
        UserService.save(User);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(UserService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(UserService.findById(id));
    }
}
