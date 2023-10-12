package poo3.demo.dao;

import org.springframework.stereotype.Service;
import poo3.demo.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserDAO {
    public List<User> users;

    public UserDAO(){
        users = new ArrayList<>();
    }

    public void addUser(User user){
        users.add(user);
    }

    public List<User> getUsers(){
        return users;
    }

    public User getUserByUsername(String username) throws NoSuchElementException {
        return this.getUsers().stream()
                .filter((User user) -> {
                    return user.getUsername().equals(username);
                }).findFirst().get();
    }

}
