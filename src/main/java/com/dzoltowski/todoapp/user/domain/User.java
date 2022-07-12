package com.dzoltowski.todoapp.user.domain;

import com.dzoltowski.todoapp.todo.domain.Todo;
import com.dzoltowski.todoapp.userrole.domain.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    private Long id;
    private String username;
    private String password;
    private Set<UserRole> userRoles = new HashSet<>();
    private Set<Todo> todos = new HashSet<>();


    public void addRole(UserRole userRole) {
        this.userRoles.add(userRole);
    }
}
