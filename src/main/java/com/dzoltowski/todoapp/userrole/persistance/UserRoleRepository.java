package com.dzoltowski.todoapp.userrole.persistance;

import com.dzoltowski.todoapp.userrole.domain.UserRole;
import com.dzoltowski.todoapp.userrole.utils.UserRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRoleRepository {
    private final UserRoleJpaRepository userRoleJpaRepository;
    private final UserRoleMapper mapper;

    public UserRole createRoleIfNotFound(UserRole userRole) {
        Optional<UserRoleEntity> roleEntity = userRoleJpaRepository.getByName(userRole.getName());
        UserRole role;
        if (roleEntity.isPresent()) {
            role = mapper.mapToDomain(roleEntity.get());
        } else {
            role = mapper.mapToDomain(userRoleJpaRepository.save(mapper.mapToEntity(userRole)));
        }
        return role;
    }
}
