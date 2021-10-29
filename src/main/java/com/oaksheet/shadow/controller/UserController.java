package com.oaksheet.shadow.controller;

import com.oaksheet.shadow.model.User;
import com.oaksheet.shadow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/addUser")
    public String addUser(Model model) {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String email, @RequestParam String password, Model model) {
        User user = new User(email, password);
        userRepository.save(user);
        return "home";
    }
}
