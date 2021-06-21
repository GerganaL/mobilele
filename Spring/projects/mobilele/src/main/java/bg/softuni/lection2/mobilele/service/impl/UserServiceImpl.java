package bg.softuni.lection2.mobilele.service.impl;

import bg.softuni.lection2.mobilele.model.entites.UserEntity;
import bg.softuni.lection2.mobilele.repository.UserRepository;
import bg.softuni.lection2.mobilele.security.CurrentUser;
import bg.softuni.lection2.mobilele.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(PasswordEncoder passwordEncoder,
                           UserRepository userRepository, CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public boolean authenticate(String username, String password) {
        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(username);
        if (userEntityOptional.isEmpty()) {
            return false;
        } else {
            return passwordEncoder.matches(password, userEntityOptional.get().getPassword());
        }
    }

    @Override
    public void loginUser(String username) {
        currentUser.setAnonymous(false).setName(username);
    }

    @Override
    public void logoutCurrentUser() {
        currentUser.setAnonymous(true);
    }
}
