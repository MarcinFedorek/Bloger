package com.project.blog.miniblog.service;

import com.project.blog.miniblog.model.dto.postDto.*;
import com.project.blog.miniblog.model.postUser.PostUser;
import com.project.blog.miniblog.repository.PostUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostUserService {

    @Autowired
    private PostUserRepository postUserRepository;

    public Optional<PostUser> addPost(AddPostDto dto) {
        PostUser post = new PostUser(dto.getTitle(),
                dto.getText(),
                dto.getLocalDateTime());

        post = postUserRepository.save(post);

        return Optional.of(post);


    }


    public List<PostDto> getPostList() {
        List<PostUser> list = postUserRepository.findAll();

        return list.stream()
                .map(postUser -> PostDto.createPostDto(postUser))
                .collect(Collectors.toList());
    }


    public Optional<PostUser> editPost(Long id, EditPostDto dto) {
        Optional<PostUser> searchPost = postUserRepository.findById(id);

        if (searchPost.isPresent()) {
            PostUser post = searchPost.get();

            post.setTitle(dto.getEdited_title());
            post.setText(dto.getEdited_text());
            post.setLocalDateTime(LocalDateTime.now());
            post.setPostStatus(dto.getPostStatus());

            post = postUserRepository.save(post);
            return Optional.of(post);
        }
        return Optional.empty();
    }

    public Optional<PostUser> deletePost(Long id, UnregisterPost dto) {

        if (id != null) {
            Optional<PostUser> searchPost = postUserRepository.findById(id);
            if (searchPost.isPresent()) {
                PostUser post = searchPost.get();

                postUserRepository.delete(post);

                return Optional.of(post);
            }
        }
        return Optional.empty();
    }
}
