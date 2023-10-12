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
public class RegisterController {

    @Autowired
    private UserServiceImp userService; // para la creación de usuarios

    @GetMapping("/register")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        // guardar el usuario en la base de datos
        userService.create(user);

        return "redirect:/login";
    }


}
