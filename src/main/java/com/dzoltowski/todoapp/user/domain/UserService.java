package com.dzoltowski.todoapp.user.domain;

import com.dzoltowski.todoapp.user.persistance.UserRepository;
import com.dzoltowski.todoapp.user.utils.UserMapper;
import com.dzoltowski.todoapp.user.web.ChangePasswordData;
import com.dzoltowski.todoapp.user.web.RegistrationData;
import com.dzoltowski.todoapp.user.web.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserModel registerUser(RegistrationData registrationData) {
        return userMapper.mapToModel(userRepository.registerNewUser(registrationData));
    }

    public UserModel changePassword(ChangePasswordData changePasswordData, String username) {
        return userMapper.mapToModel(
                userRepository.changePassword(changePasswordData.getPassword(), username)
        );
    }
}
