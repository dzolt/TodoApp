package com.dzoltowski.todoapp.user.web;

import com.dzoltowski.todoapp.user.domain.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserModel registerUser(@RequestBody RegistrationData registrationData) {
        return userService.registerUser(registrationData);
    }

    @PostMapping("/changePassword")
    public UserModel changePassword(@RequestBody ChangePasswordData changePasswordData, Principal principal, Authentication authentication) {
        return userService.changePassword(changePasswordData, principal.getName());
    }
}
