package com.dzoltowski.todoapp.user.web;

import com.dzoltowski.todoapp.todo.domain.Todo;
import com.dzoltowski.todoapp.userrole.domain.UserRole;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {
    private String username;
    private String password;
    private Set<UserRole> userRoles;
    private Set<Todo> todos;
}
