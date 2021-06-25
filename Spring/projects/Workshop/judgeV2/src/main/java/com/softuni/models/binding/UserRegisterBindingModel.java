package com.softuni.models.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class UserRegisterBindingModel {
    @Length(min = 2, message = "username length must be minimum two characters!")
    private String username;
    @Length(min = 3, message = "password length must be minimum three characters!")
    private String password;
    private String confirmPassword;
    @Email(message = "email must contains '@'")
    private String email;
    @Pattern(regexp = "^https:\\/\\/github\\.com\\/.+$", message = "git must be a valid github address in pattern: https:/github.com/{username}/SpringTestData/…")
    private String git;

    public UserRegisterBindingModel() {
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }
}
