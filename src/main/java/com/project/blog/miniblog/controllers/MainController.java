package com.project.blog.miniblog.controllers;

import com.project.blog.miniblog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {


    @GetMapping("/")
    public String root() {
        return "index";
    }

    @RequestMapping("login")
    public String login(Model model) {
        return "login";
    }
}

