package com.project.blog.miniblog.repository;

import com.project.blog.miniblog.model.AppUser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    int countByEmail(String email);

    Optional<AppUser> findByEmail(String email);

    @Query("select u from AppUser u where u.username =:username")
    AppUser findByUsername(@Param("username") String username);

}
