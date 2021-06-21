package com.softuni.service.impl;

import com.softuni.models.entity.RoleNameEnum;
import com.softuni.models.entity.UserEntity;
import com.softuni.models.service.UserServiceModel;
import com.softuni.repository.UserRepository;
import com.softuni.security.CurrentUser;
import com.softuni.service.RoleService;
import com.softuni.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        UserEntity user = modelMapper.map(userServiceModel,UserEntity.class);
        user.setRole(roleService.findRole(RoleNameEnum.USER));

        userRepository.save(user);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return userRepository.
                findByUsernameAndPassword(username,password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void login(UserServiceModel userServiceModel) {
        currentUser.setId(userServiceModel.getId())
                .setUsername(userServiceModel.getUsername())
                .setRole(userServiceModel.getRole().getName());
    }

    @Override
    public void logout() {
        currentUser.setId(null).setUsername(null).setRole(null);
    }
}
