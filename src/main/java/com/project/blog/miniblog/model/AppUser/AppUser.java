package com.project.blog.miniblog.model.AppUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


@Entity
@AllArgsConstructor
@Data
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String email;
    private String password;

    @Column(name = "username")
    private String username;
    private String surname;
    private String descriptionAcount;
    private LocalDate dateOfCreateAcount;
    private AccountStatus accountStatus;
    private TypeOfAccount typeOfAccount;


    @Column(name = "authorities")
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;


    public AppUser() {
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public AppUser(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    public void setPassword(String password) {

        this.password = password;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setName(String name) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDescriptionAcount() {
        return descriptionAcount;
    }

    public void setDescriptionAcount(String descriptionAcount) {
        this.descriptionAcount = descriptionAcount;
    }

    public LocalDate getDateOfCreateAcount() {
        return dateOfCreateAcount;
    }

    public void setDateOfCreateAcount(LocalDate dateOfCreateAcount) {
        this.dateOfCreateAcount = dateOfCreateAcount;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public TypeOfAccount getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(TypeOfAccount typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }
}
