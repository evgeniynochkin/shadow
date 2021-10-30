package com.oaksheet.shadow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

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
}
