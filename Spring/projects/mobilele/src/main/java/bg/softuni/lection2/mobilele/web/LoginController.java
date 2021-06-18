package bg.softuni.lection2.mobilele.web;

import bg.softuni.lection2.mobilele.security.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private final CurrentUser currentUser;

    public LoginController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/users/login")
    public String login(){

        return "auth-login";
    }
}
