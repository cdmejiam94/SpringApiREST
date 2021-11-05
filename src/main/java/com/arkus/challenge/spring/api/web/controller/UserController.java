package com.arkus.challenge.spring.api.web.controller;

import com.arkus.challenge.spring.api.domain.UserObject;
import com.arkus.challenge.spring.api.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserObject> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<UserObject> getUserById(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    @PostMapping("/save")
    public UserObject save(@RequestBody UserObject userObject){
        return userService.save(userObject);
    }

    @GetMapping("/login/{user}/{password}")
    public Optional<UserObject> login(@PathVariable("user") String user, @PathVariable("password") String password){
        return userService.login(user,password);
    }
}
