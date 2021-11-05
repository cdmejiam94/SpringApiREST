package com.arkus.challenge.spring.api.persistance.mapper;

import com.arkus.challenge.spring.api.domain.AccountObject;
import com.arkus.challenge.spring.api.persistance.entity.Account;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mappings({
            @Mapping(source = "idCuenta", target = "idCuenta"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "cliente", target = "cliente"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "modifiedAt", target = "modifiedAt"),
            @Mapping(source = "responsableUser", target = "responsable")
    })
    AccountObject toAccount(Account account);
    List<AccountObject> toAccounts(List<Account> accounts);

    @InheritInverseConfiguration
    @Mapping(target = "responsableUser", ignore = true)
    Account toAccountObject(AccountObject accountObject);
}
