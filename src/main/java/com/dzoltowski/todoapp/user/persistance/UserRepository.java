package com.dzoltowski.todoapp.user.persistance;

import com.dzoltowski.todoapp.user.domain.User;
import com.dzoltowski.todoapp.user.utils.UserMapper;
import com.dzoltowski.todoapp.user.web.RegistrationData;
import com.dzoltowski.todoapp.userrole.domain.UserRole;
import com.dzoltowski.todoapp.userrole.domain.UserRoles;
import com.dzoltowski.todoapp.userrole.persistance.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;

    public User registerNewUser(RegistrationData registrationData) {
        if (userJpaRepository.getByUsername(registrationData.getUsername()).isPresent()) {
            throw new RuntimeException("Username " + registrationData.getUsername() + " already taken");
        }

        registrationData.setPassword(encoder.encode(registrationData.getPassword()));

        User newUser = userMapper.mapToDomain(registrationData);
        addNewRoleToUser(newUser, UserRole.builder().name(UserRoles.USER.name()).build());

        return userMapper.mapToDomain(userJpaRepository.save(userMapper.mapToEntity(newUser)));
    }

    private void addNewRoleToUser(User user, UserRole role) {
        role = userRoleRepository.createRoleIfNotFound(role);
        user.addRole(role);
    }

    public UserEntity getUserEntityByUserName(String username) {
        return userJpaRepository
                .getByUsername(username)
                .orElseThrow(() -> new RuntimeException("No user with username " + username));
    }

    private User updateUser(UserEntity user) {
        return userMapper.mapToDomain(userJpaRepository.save(user));
    }

    public User changePassword(String password, String username) {
        UserEntity user = getUserEntityByUserName(username);

        if (password.equals(user.getPassword())) {
            throw new RuntimeException("Passwords cannot be the same!");
        }
        user.setPassword(encoder.encode(password));
        System.out.println(user.getPassword());

        return updateUser(user);
    }
}
