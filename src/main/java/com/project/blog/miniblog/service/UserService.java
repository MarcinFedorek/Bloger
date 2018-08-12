package com.project.blog.miniblog.service;


import com.project.blog.miniblog.dto.UserRegistrationDto;
import com.project.blog.miniblog.model.AppUser.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}