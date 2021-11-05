package com.arkus.challenge.spring.api.web.controller;

import com.arkus.challenge.spring.api.domain.AccountObject;
import com.arkus.challenge.spring.api.domain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/all")
    public List<AccountObject> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<AccountObject> getAccountById(@PathVariable("id") int id){
        return accountService.getAccount(id);
    }

    @PostMapping("/save")
    public AccountObject save(@RequestBody AccountObject accountObject){
        return accountService.save(accountObject);
    }
}
