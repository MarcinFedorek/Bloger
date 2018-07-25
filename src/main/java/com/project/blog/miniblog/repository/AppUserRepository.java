package com.project.blog.miniblog.repository;

import com.project.blog.miniblog.model.AppUser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    int countByEmail(String email);
}
