package com.oaksheet.shadow.controller;

import com.oaksheet.shadow.model.Role;
import com.oaksheet.shadow.model.User;
import com.oaksheet.shadow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "SHADOW");
        return "home";
    }

    @GetMapping("/homeLogin")
    public String homeLogin(Model model) {
        model.addAttribute("title", "SHADOW");
        return "homeLogin";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        return "/registration";
    }

    @PostMapping("/registration")
    public String registrationUser(User user, Map<String, Object> model) {
        User userFromDB = userRepository.findByEmail(user.getEmail());

        if (userFromDB != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        return "redirect:/login";
    }
}
