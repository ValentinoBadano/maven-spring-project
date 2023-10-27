package poo3.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import poo3.demo.service.UserServiceImp;

@Controller
public class IndexController {

    @Autowired
    private UserServiceImp userService;

    @GetMapping("/index")
    public String welcomePage(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "index";
    }
}
