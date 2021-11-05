package com.arkus.challenge.spring.api.domain.service;

import com.arkus.challenge.spring.api.domain.UserObject;
import com.arkus.challenge.spring.api.domain.repository.UserRepository;
import com.arkus.challenge.spring.api.utils.ProjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserObject> getAll(){
        return userRepository.getAll();
    }

    public UserObject save(UserObject user){
        user.setCreatedAt(ProjectUtils.getDateYYYYMMDD());
        user.setModifiedAt(ProjectUtils.getDateYYYYMMDD());
        return userRepository.save(user);
    }

    public Optional<UserObject> getUser(int id){
        return userRepository.getUser(id);
    }

    public boolean delete(int id){
        return getUser(id).map(userObject -> {
            userRepository.delete(id);
            return true;
        }).orElse(false);
    }

    public Optional<UserObject> login(String user, String password){
        return userRepository.login(user, password);
    }

}
