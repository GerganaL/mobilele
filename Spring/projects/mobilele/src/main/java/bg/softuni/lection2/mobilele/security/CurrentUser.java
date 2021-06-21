package bg.softuni.lection2.mobilele.security;

import bg.softuni.lection2.mobilele.model.entites.enums.UserRoleEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class CurrentUser {
    private static final String ANONYMOUS_NAME = "anonymous";
    private String name = ANONYMOUS_NAME;
    private boolean isAnonymous = true;
    private List<UserRoleEnum> userRoles = new ArrayList<>();

    public static String getANONYMOUS() {
        return ANONYMOUS_NAME;
    }

    public String getName() {
        return name;
    }

    public CurrentUser setName(String name) {
        this.name = name;
        return this;
    }

    public CurrentUser setUserRoles(List<UserRoleEnum> newRoles) {
        userRoles.clear();
        userRoles.addAll(newRoles);
        return this;
    }

    public boolean isAdmin(){
        return  userRoles.contains(UserRoleEnum.ADMIN);
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public boolean isLoggedIn() {
        return !isAnonymous;
    }

    public CurrentUser setAnonymous(boolean anonymous) {
        if (anonymous) {
            this.name = ANONYMOUS_NAME;
            this.userRoles.clear();
        }
        isAnonymous = anonymous;
        return this;
    }
}
