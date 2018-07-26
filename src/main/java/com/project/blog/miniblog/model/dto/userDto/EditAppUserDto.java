package com.project.blog.miniblog.model.dto.userDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditAppUserDto {
    private String edited_name;
    private String edited_surname;
    private String edited_description;
}