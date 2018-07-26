package com.project.blog.miniblog.model.dto.userDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnregisterDto {
    private Long unregister_id;
    private String unregister_email;
    private String unregister_password;
}
