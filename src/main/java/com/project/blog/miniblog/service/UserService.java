package com.project.blog.miniblog.service;


import com.project.blog.miniblog.model.AppUser.User;
import com.project.blog.miniblog.model.AppUser.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);

    List<User> findAll();
}