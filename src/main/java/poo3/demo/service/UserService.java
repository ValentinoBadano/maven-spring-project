package poo3.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import poo3.demo.model.User;

public interface UserService extends UserDetailsService {
    User create(User user);
}
