package com.linktic.microservice_user.persistence;

import com.linktic.microservice_user.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Long> {
}
