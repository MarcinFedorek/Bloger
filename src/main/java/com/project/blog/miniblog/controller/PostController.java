package com.project.blog.miniblog.controller;

import com.project.blog.miniblog.model.dto.postDto.*;
import com.project.blog.miniblog.model.postUser.PostUser;
import com.project.blog.miniblog.service.PostUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class PostController {

    @Autowired
    private PostUserService postUserService;

    @PostMapping("/addPost")
    public void AddPost(@RequestBody AddPostDto dto){
        postUserService.addPost(dto);
    }

    @PostMapping("/deletePost")
    public ResponseEntity<DeletePostDto>deletePost(@RequestBody UnregisterPost dto){
        Optional<PostUser>removePost = postUserService.deletePost(dto.getDeleted_id(),dto);
            if (removePost.isPresent()){
                return ResponseEntity.ok(new DeletePostDto(removePost.get()));

            }
            return ResponseEntity.badRequest().build();
    }

    @PostMapping("/editPost/{id}")
    public ResponseEntity<PostUser> editPost(@PathVariable(name = "id") Long id,
                                             @RequestBody EditPostDto dto){
        Optional<PostUser>editPost = postUserService.editPost(id, dto);
        if (editPost.isPresent()){
            return ResponseEntity.ok(editPost.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/listPosts")
    public ResponseEntity<List<PostDto>> listPosts(){
        return ResponseEntity.ok(postUserService.getPostList());
    }
}
