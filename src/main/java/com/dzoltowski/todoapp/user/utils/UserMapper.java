package com.dzoltowski.todoapp.user.utils;

import com.dzoltowski.todoapp.user.domain.User;
import com.dzoltowski.todoapp.user.persistance.UserEntity;
import com.dzoltowski.todoapp.user.web.RegistrationData;
import com.dzoltowski.todoapp.user.web.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    UserEntity mapToEntity(User user);

    User mapToDomain(UserEntity userEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userRoles", ignore = true)
    @Mapping(target = "todos", ignore = true)
    User mapToDomain(RegistrationData registrationData);

    @Mapping(target = "id", ignore = true)
    UserModel mapToModel(User user);

    @Mapping(target = "id", ignore = true)
    User mapToDomain(UserModel userModel);
}
