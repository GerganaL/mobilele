package com.softuni.service;

import com.softuni.models.entity.RoleNameEnum;
import com.softuni.models.entity.UserEntity;
import com.softuni.models.service.UserServiceModel;

import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void login(UserServiceModel userServiceModel);

    void logout();

    List<String> findAllUsernames();

    void changeRole(String username, RoleNameEnum roleNameEnum);

    UserEntity findById(Long id);
}
