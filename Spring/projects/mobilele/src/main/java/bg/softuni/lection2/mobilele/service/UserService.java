package bg.softuni.lection2.mobilele.service;

public interface UserService {
    /**
     *
     * @param username
     * @param password
     * @return true if the user authenticates successfully
     */
    boolean authenticate(String username, String password);
    void loginUser(String username);
}
