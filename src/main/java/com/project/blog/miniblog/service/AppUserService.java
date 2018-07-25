package com.project.blog.miniblog.service;

import com.project.blog.miniblog.model.AppUser.AppUser;
import com.project.blog.miniblog.model.dto.AppUserDto;
import com.project.blog.miniblog.model.dto.EditAppUserDto;
import com.project.blog.miniblog.model.dto.RegisterUserDto;
import com.project.blog.miniblog.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;



    public Optional<AppUser> registerUser(RegisterUserDto registerUserDto) {
        registerUserDto.setRegister_email(registerUserDto.getRegister_email().toLowerCase());


        if (registerUserDto.getRegister_password().equals(registerUserDto.getRegister_password_confirm())) {

            if (appUserRepository.countByEmail(registerUserDto.getRegister_email()) <= 0) {
                AppUser createdUser = new AppUser(
                        registerUserDto.getRegister_email(),
                        registerUserDto.getRegister_password());

                createdUser = appUserRepository.save(createdUser);

                return Optional.of(createdUser);
            }

        }
        return Optional.empty();
    }

    public List<AppUserDto> getUserList() {
        List<AppUser> list = appUserRepository.findAll();

        return list.stream()
                .map(user -> AppUserDto.createDto(user))
                .collect(Collectors.toList());
    }

    public Optional<AppUser> editUser(Long id, EditAppUserDto dto) {

        Optional<AppUser> searchedUser = appUserRepository.findById(id);

        if (searchedUser.isPresent()) {

            AppUser user = searchedUser.get();


            user.setName(dto.getEdited_name());
            user.setSurname(dto.getEdited_surname());

            // aby zapobiec modyfikowaniu na null
            if (dto.getEdited_surname() != null) {
                user.setSurname(dto.getEdited_surname());
            }

            // zapisuje użytkownika - po lewej stronie przypisuje do zmiennej user
            // użytkownika zwróconego przez bazę danych (zmodyfikowanego)
            user = appUserRepository.save(user);

            // zwracam zmodyfikowany wpis
            return Optional.of(user);
        }
        // jeśli nie udało się znaleźć usera, zwracamy pusty optional
        return Optional.empty();
    }

}
