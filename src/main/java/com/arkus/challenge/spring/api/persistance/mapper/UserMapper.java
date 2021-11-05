package com.arkus.challenge.spring.api.persistance.mapper;

import com.arkus.challenge.spring.api.domain.UserObject;
import com.arkus.challenge.spring.api.persistance.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "idUsuario", target = "id"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "nivelIngles", target = "englishLevel"),
            @Mapping(source = "conocimientosTecnicos", target = "technicalKnowledge"),
            @Mapping(source = "linkCv", target = "cv"),
            @Mapping(source = "role", target = "role"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "modifiedAt", target = "modifiedAt"),
    })
    UserObject toUser(User user);
    List<UserObject> toUsers(List<User> users);

    @InheritInverseConfiguration
    User toUserObject(UserObject userObject);
}
