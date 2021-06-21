package com.softuni.service;

import com.softuni.models.entity.RoleEntity;
import com.softuni.models.entity.RoleNameEnum;

public interface RoleService {
    void initRoles();
    RoleEntity findRole(RoleNameEnum roleNameEnum);
}
