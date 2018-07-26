package com.project.blog.miniblog.model.dto.postDto;

import com.project.blog.miniblog.model.postUser.PostStatus;
import com.project.blog.miniblog.model.postUser.PostUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto
{

    private Long id;
    private String title;
    private String text;
    private LocalDateTime localDateTime;
    private PostStatus postStatus;

    public static PostDto createPostDto(PostUser post){
        return new PostDto(post.getId(),
                post.getTitle(),
                post.getText(),
                post.getLocalDateTime(),
                post.getPostStatus());
    }



}
