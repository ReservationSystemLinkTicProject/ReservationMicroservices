package com.linktic.microservice_user.service;

import com.linktic.microservice_user.entities.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(Long id);
    void save(User student);
}
