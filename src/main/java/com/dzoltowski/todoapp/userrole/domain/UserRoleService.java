package com.dzoltowski.todoapp.userrole.domain;

import com.dzoltowski.todoapp.userrole.persistance.UserRoleRepository;
import com.dzoltowski.todoapp.userrole.utils.UserRoleMapper;
import com.dzoltowski.todoapp.userrole.web.UserRoleModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final UserRoleMapper mapper;

    public UserRoleModel createRoleIfNotFound(UserRole userRole) {
        return mapper.mapToModel(userRoleRepository.createRoleIfNotFound(userRole));
    }
}
