package com.softuni.models.binding;

import org.hibernate.validator.constraints.Length;

public class UserBindingModel {
    @Length(min = 2, message = "username length must be minimum two characters!")
    private String username;
    @Length(min = 3, message = "password length must be minimum three characters!")
    private String password;

    public UserBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
