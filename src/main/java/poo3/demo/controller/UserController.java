package poo3.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import poo3.demo.model.User;
import poo3.demo.service.UserServiceImp;

@Controller
public class UserController {

    @Autowired
    private UserServiceImp userService; // Debes tener un servicio para gestionar la autenticación

    @GetMapping("/register")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        // Validar y guardar el usuario en la base de datos
        userService.create(user);
        return "redirect:/login";
    }


}
