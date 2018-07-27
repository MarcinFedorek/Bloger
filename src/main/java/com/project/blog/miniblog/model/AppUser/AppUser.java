package com.project.blog.miniblog.model.AppUser;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String email;
    private String password;


    private String name;
    private String surname;
    private String descriptionAcount;
    private LocalDate dateOfCreateAcount;
    private AccountStatus accountStatus;
    private TypeOfAccount typeOfAccount;

    public AppUser() {
    }

    public AppUser(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
