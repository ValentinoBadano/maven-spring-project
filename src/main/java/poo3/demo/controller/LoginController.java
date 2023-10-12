package poo3.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import poo3.demo.model.User;
import poo3.demo.service.UserServiceImp;

@Controller
public class LoginController {
    @Autowired
    private UserServiceImp userService;
    @Autowired
    private AuthenticationProvider authenticationProvider;


    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute ("user") User user) {
        authenticateUser(user.getUsername(), user.getPassword());
        return "redirect:index";
    }

    public void authenticateUser(String username, String password) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
        authenticationProvider.authenticate(authentication);
    }

}
