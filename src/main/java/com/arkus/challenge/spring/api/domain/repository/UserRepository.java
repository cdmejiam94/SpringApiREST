package com.arkus.challenge.spring.api.domain.repository;

import com.arkus.challenge.spring.api.domain.UserObject;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<UserObject> getAll();
    UserObject save(UserObject user);
    Optional<UserObject> getUser(int id);
    Optional<UserObject> login(String user, String password);
    void delete(int id);
}
