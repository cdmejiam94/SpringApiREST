package com.arkus.challenge.spring.api.domain.repository;

import com.arkus.challenge.spring.api.domain.AccountObject;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    List<AccountObject> getAll();
    AccountObject save(AccountObject accountObject);
    Optional<AccountObject> getAccount(int id);
    void delete(int id);
}
