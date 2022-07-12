package com.dzoltowski.todoapp.userrole.web;

import com.dzoltowski.todoapp.userrole.domain.UserRoleService;
import com.dzoltowski.todoapp.userrole.utils.UserRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("role")
public class UserRoleController {

    private final UserRoleMapper mapper;
    private final UserRoleService service;

    @PostMapping("/create")
    public UserRoleModel createNewRole(@RequestBody CreateNewRoleData newRoleData) {
        return service.createRoleIfNotFound(mapper.mapToDomainFromCreateNewRoleData(newRoleData));
    }
}
