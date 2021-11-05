package com.arkus.challenge.spring.api.domain.service;

import com.arkus.challenge.spring.api.domain.AccountObject;
import com.arkus.challenge.spring.api.domain.repository.AccountRepository;
import com.arkus.challenge.spring.api.utils.ProjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<AccountObject> getAll(){
        return accountRepository.getAll();
    }

    public AccountObject save(AccountObject account){
        account.setCreatedAt(ProjectUtils.getDateYYYYMMDD());
        account.setModifiedAt(ProjectUtils.getDateYYYYMMDD());
        return accountRepository.save(account);
    }

    public Optional<AccountObject> getAccount(int id){
        return accountRepository.getAccount(id);
    }

    public boolean delete(int id){
        return getAccount(id).map(userObject -> {
            accountRepository.delete(id);
            return true;
        }).orElse(false);
    }
}
