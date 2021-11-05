package com.arkus.challenge.spring.api.persistance;

import com.arkus.challenge.spring.api.domain.UserAccountObject;
import com.arkus.challenge.spring.api.domain.repository.UserAccountRepository;
import com.arkus.challenge.spring.api.persistance.crud.UserAccountCrudRepository;
import com.arkus.challenge.spring.api.persistance.entity.UserAccount;
import com.arkus.challenge.spring.api.persistance.mapper.UserAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserAccountRepositoryImpl implements UserAccountRepository {

    private static final String RESPONSABLE = "1";

    @Autowired
    private UserAccountCrudRepository userAccountCrudRepository;

    @Autowired
    private UserAccountMapper mapper;

    @Override
    public UserAccountObject save(UserAccountObject userAccountObject) {
        UserAccount userAccount = mapper.toUserAccountObject(userAccountObject);
        return mapper.toUserAccount(userAccountCrudRepository.save(userAccount));
    }
}
