package com.project.blog.miniblog.model.dto.userDto;

import com.project.blog.miniblog.model.AppUser.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDto {

    private Long id;
    private String email;
    private String password;
    private String name;
    private String surname;

    public static AppUserDto createDto(AppUser user){
        return new AppUserDto(user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getName(),
                user.getSurname());
    }
}