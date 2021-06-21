package bg.softuni.lection2.mobilele.web;

import bg.softuni.lection2.mobilele.model.service.UserLoginServiceModel;
import bg.softuni.lection2.mobilele.security.CurrentUser;
import bg.softuni.lection2.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {

        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginServiceModel model) {
        if (userService.authenticate(model.getUsername(), model.getPassword())) {
            userService.loginUser(model.getUsername());
            return "redirect:/";
        } else {
            return "redirect:/users/login";
        }
    }

    @PostMapping("/users/logout")
    public String logout() {
        userService.logoutCurrentUser();
        return "redirect:/";
    }

}
