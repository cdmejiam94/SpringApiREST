package com.arkus.challenge.spring.api.domain.repository;

import com.arkus.challenge.spring.api.domain.UserAccountObject;

public interface UserAccountRepository {
    UserAccountObject save(UserAccountObject userAccountObject);
}
