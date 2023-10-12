package poo3.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import poo3.demo.dao.UserDAO;
import poo3.demo.model.User;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User create(User user) {
        // se encripta la contraseña
        user.setPassword(new
                BCryptPasswordEncoder().encode(user.getPassword()));

        // Agregamos el usuario al DAO
        userDAO.addUser(user);

        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDAO.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return user;
    }
}
