package com.project.blog.miniblog.model.dto.postDto;

import com.project.blog.miniblog.model.postUser.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditPostDto {

    private String edited_title;
    private String edited_text;
    private PostStatus postStatus;


}
