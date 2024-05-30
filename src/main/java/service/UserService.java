package service;

import org.springframework.security.core.userdetails.User;

public interface UserService {
    User saveUser(User user);
    User findByUsername(String username);
}
