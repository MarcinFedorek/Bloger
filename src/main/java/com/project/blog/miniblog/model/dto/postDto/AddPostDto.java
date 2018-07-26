package com.project.blog.miniblog.model.dto.postDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPostDto {

    private String title;
    private String text;
    private LocalDateTime localDateTime;
}
