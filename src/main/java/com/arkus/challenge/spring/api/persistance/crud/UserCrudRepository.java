package com.arkus.challenge.spring.api.persistance.crud;

import com.arkus.challenge.spring.api.persistance.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmailAndPassword(String user, String password);
}
