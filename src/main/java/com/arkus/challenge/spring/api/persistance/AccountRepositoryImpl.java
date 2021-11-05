package com.arkus.challenge.spring.api.persistance;

import com.arkus.challenge.spring.api.domain.AccountObject;
import com.arkus.challenge.spring.api.domain.repository.AccountRepository;
import com.arkus.challenge.spring.api.persistance.crud.AccountCrudRepository;
import com.arkus.challenge.spring.api.persistance.entity.Account;
import com.arkus.challenge.spring.api.persistance.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private AccountCrudRepository accountCrudRepository;

    @Autowired
    private AccountMapper mapper;

    @Override
    public List<AccountObject> getAll() {
        List<Account> accounts = (List<Account>) accountCrudRepository.getAllAccounts();
        return mapper.toAccounts(accounts);
    }

    @Override
    public AccountObject save(AccountObject accountObject) {
        Account account = mapper.toAccountObject(accountObject);
        return mapper.toAccount(accountCrudRepository.save(account));
    }

    @Override
    public Optional<AccountObject> getAccount(int id) {
        return accountCrudRepository.findById(id).map(account -> mapper.toAccount(account));
    }

    @Override
    public void delete(int id) {
        accountCrudRepository.deleteById(id);
    }
}
