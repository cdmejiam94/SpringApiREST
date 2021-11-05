package com.arkus.challenge.spring.api.web.controller;

import com.arkus.challenge.spring.api.domain.UserAccountObject;
import com.arkus.challenge.spring.api.domain.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users-accounts")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    @PutMapping("/update")
    public UserAccountObject update(@RequestBody UserAccountObject userAccountObject){
        return userAccountService.save(userAccountObject);
    }

    @PostMapping("/save")
    public UserAccountObject save(@RequestBody UserAccountObject userAccountObject){
        return userAccountService.save(userAccountObject);
    }
}
