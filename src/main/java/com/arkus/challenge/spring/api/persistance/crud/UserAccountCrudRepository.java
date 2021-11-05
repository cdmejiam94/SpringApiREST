package com.arkus.challenge.spring.api.persistance.crud;

import com.arkus.challenge.spring.api.persistance.entity.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountCrudRepository extends CrudRepository<UserAccount, Integer> {
}
