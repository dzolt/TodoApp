package com.dzoltowski.todoapp.userrole.persistance;

import com.dzoltowski.todoapp.userrole.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleJpaRepository extends JpaRepository<UserRoleEntity, Long> {

    Optional<UserRoleEntity> getByName(String name);
}
