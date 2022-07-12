package com.dzoltowski.todoapp.userrole.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserRole {
    private Long id;
    private String name;
}
