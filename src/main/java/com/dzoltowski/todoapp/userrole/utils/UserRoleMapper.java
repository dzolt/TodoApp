package com.dzoltowski.todoapp.userrole.utils;

import com.dzoltowski.todoapp.userrole.domain.UserRole;
import com.dzoltowski.todoapp.userrole.persistance.UserRoleEntity;
import com.dzoltowski.todoapp.userrole.web.CreateNewRoleData;
import com.dzoltowski.todoapp.userrole.web.UserRoleModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {

    UserRole mapToDomain(UserRoleEntity userRoleEntity);

    @Mapping(target = "id", ignore = true)
    UserRoleEntity mapToEntity(UserRole userRole);

    @Mapping(target = "id", ignore = true)
    UserRole mapToDomainFromCreateNewRoleData(CreateNewRoleData newRoleData);

    @Mapping(target = "id", ignore = true)
    UserRoleModel mapToModel(UserRole userRole);
}
