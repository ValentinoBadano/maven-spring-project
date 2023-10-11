package poo3.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import poo3.demo.model.User;
import poo3.demo.service.UserServiceImp;

@Controller
public class UserController {

    @Autowired
    private UserServiceImp userService; // Debes tener un servicio para gestionar la autenticación

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
}
