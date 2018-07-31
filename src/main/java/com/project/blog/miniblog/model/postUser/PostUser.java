package com.project.blog.miniblog.model.postUser;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class PostUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;
    private String text;
    private LocalDateTime localDateTime = LocalDateTime.now();
    private PostStatus postStatus;


    public PostUser() {
    }

    public PostUser(String title, String text, LocalDateTime localDateTime) {
        this.title = title;
        this.text = text;
        this.localDateTime = localDateTime;
    }
}
