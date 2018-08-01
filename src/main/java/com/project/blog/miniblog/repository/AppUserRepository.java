package com.project.blog.miniblog.repository;

import com.project.blog.miniblog.model.AppUser.AppUser;
import com.project.blog.miniblog.model.AppUser.TypeOfAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    int countByEmail(String email);

    Optional<AppUser> findByEmail(String email);

}
