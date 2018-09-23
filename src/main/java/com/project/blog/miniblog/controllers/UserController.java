package com.project.blog.miniblog.controllers;

import com.project.blog.miniblog.repository.UserRepository;
import com.project.blog.miniblog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @RequestMapping({"", "/","/users"})
    public String listUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/users";
    }
}
