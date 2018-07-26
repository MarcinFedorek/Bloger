package com.project.blog.miniblog.model.dto.userDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDto {

    private String register_email;
    private String register_password;
    private String register_password_confirm;

}
