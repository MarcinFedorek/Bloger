package com.project.blog.miniblog.service;

import com.project.blog.miniblog.model.AppUser.AppUser;
import com.project.blog.miniblog.model.AppUser.Role;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("CustomUserDetailService")
public class CustomUserDetailService implements UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = new AppUser();
        List<Role> roles = new ArrayList<>();
        if(username.equals("user"))
        {
            Role role = new Role();
            user.setUsername("user");
            user.setPassword("123");
            role.setName("ROLE_ADMIN");
            roles.add(role);
            user.setRoles(roles);
        }
        return user;
    }

}
