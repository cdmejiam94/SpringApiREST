package com.arkus.challenge.spring.api.persistance.mapper;

import com.arkus.challenge.spring.api.domain.UserAccountObject;
import com.arkus.challenge.spring.api.persistance.entity.UserAccount;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {

    @Mappings({
            @Mapping(source = "idUser", target = "idUser"),
            @Mapping(source = "idAccount", target = "idAccount"),
            @Mapping(source = "responsable", target = "responsable"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "modifiedAt", target = "modifiedAt"),
    })
    UserAccountObject toUserAccount(UserAccount userAccount);

    @InheritInverseConfiguration
    UserAccount toUserAccountObject(UserAccountObject userAccountObject);
}
