package com.project.blog.miniblog.model.dto;

import com.project.blog.miniblog.model.AppUser.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteUserDto {
    private AppUser deletedUser;
}
