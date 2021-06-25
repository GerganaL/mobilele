package com.softuni.service.impl;

import com.softuni.models.entity.RoleEntity;
import com.softuni.models.entity.RoleNameEnum;
import com.softuni.repository.RoleRepository;
import com.softuni.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRoles() {
        if(roleRepository.count() == 0){
            RoleEntity admin = new RoleEntity(RoleNameEnum.ADMIN);
            RoleEntity user = new RoleEntity(RoleNameEnum.USER);

            roleRepository.save(admin);
            roleRepository.save(user);
        }
    }

    @Override
    public RoleEntity findRole(RoleNameEnum roleNameEnum) {
        return roleRepository.findByName(roleNameEnum).orElse(null);
    }
}
