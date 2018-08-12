package com.project.blog.miniblog.repository;

import com.project.blog.miniblog.model.AppUser.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByEmail(String email);



}
