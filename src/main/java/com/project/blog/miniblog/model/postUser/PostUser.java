package com.project.blog.miniblog.model.postUser;

import com.project.blog.miniblog.model.AppUser.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
public class PostUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String title;
    private String text;
    private LocalDateTime localDateTime = LocalDateTime.now();
    private PostStatus postStatus;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    private User user;


    public PostUser() {
    }

    public PostUser(String title, String text, LocalDateTime localDateTime) {
        this.title = title;
        this.text = text;
        this.localDateTime = localDateTime;
    }
}
