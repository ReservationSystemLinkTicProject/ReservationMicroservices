package com.linktic.microservice_user.service;

import com.linktic.microservice_user.entities.User;
import com.linktic.microservice_user.persistence.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  IUserService{
    @Autowired
    private IUserRepository IUserRepository;

    @Override
    public List<User> findAll() {
        return (List<User>) IUserRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return IUserRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(User User) {
        IUserRepository.save(User);
    }
}
