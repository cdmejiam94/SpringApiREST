package com.arkus.challenge.spring.api.domain.service;

import com.arkus.challenge.spring.api.domain.UserAccountObject;
import com.arkus.challenge.spring.api.domain.repository.UserAccountRepository;
import com.arkus.challenge.spring.api.utils.ProjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;

    public UserAccountObject save(UserAccountObject userAccount){
        userAccount.setCreatedAt(ProjectUtils.getDateYYYYMMDD());
        userAccount.setModifiedAt(ProjectUtils.getDateYYYYMMDD());
        return userAccountRepository.save(userAccount);
    }

}
