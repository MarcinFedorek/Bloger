package com.project.blog.miniblog.model.dto.postDto;

import com.project.blog.miniblog.model.postUser.PostUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class deletePostDto {
    private PostUser deletedPost;
}
