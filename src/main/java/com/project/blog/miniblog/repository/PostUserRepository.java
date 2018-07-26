package com.project.blog.miniblog.repository;

import com.project.blog.miniblog.model.postUser.PostUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostUserRepository extends JpaRepository<PostUser, Long> {
}
