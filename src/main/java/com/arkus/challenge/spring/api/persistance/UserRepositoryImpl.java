package com.arkus.challenge.spring.api.persistance;

import com.arkus.challenge.spring.api.domain.UserObject;
import com.arkus.challenge.spring.api.domain.repository.UserRepository;
import com.arkus.challenge.spring.api.persistance.crud.UserCrudRepository;
import com.arkus.challenge.spring.api.persistance.entity.User;
import com.arkus.challenge.spring.api.persistance.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<UserObject> getAll() {
        List<User> users = (List<User>) userCrudRepository.findAll();
        return mapper.toUsers(users);
    }

    @Override
    public Optional<UserObject> getUser(int id) {
        return userCrudRepository.findById(id).map(user -> mapper.toUser(user));
    }

    @Override
    public UserObject save(UserObject userObject) {
        User user = mapper.toUserObject(userObject);
        return mapper.toUser(userCrudRepository.save(user));
    }

    @Override
    public void delete(int id){
        userCrudRepository.deleteById(id);
    }

    @Override
    public Optional<UserObject> login(String user, String password) {
        return userCrudRepository.findByEmailAndPassword(user, password).map(usuario -> mapper.toUser(usuario));
    }
}
