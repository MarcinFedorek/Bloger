package com.project.blog.miniblog.controller;

import com.project.blog.miniblog.model.dto.RegisterUserDto;
import com.project.blog.miniblog.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/index")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/registerUser")
    public void registerUser(@RequestBody RegisterUserDto dto){
        appUserService.registerUser(dto);
    }




}
