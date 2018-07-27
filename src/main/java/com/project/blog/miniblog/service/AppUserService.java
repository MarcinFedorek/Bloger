package com.project.blog.miniblog.service;

import com.project.blog.miniblog.model.AppUser.AppUser;
import com.project.blog.miniblog.model.dto.userDto.EditAppUserDto;
import com.project.blog.miniblog.model.dto.userDto.UnregisterDto;
import com.project.blog.miniblog.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public Long registerUser(String email, String password, String name) {
        if (!email.isEmpty() && !password.isEmpty()) {
            Optional<AppUser> userByEmail = appUserRepository.findByEmail(email);
            if (!userByEmail.isPresent()) {
                AppUser user = new AppUser();
                user.setEmail(email);
                user.setPassword(password);
                user.setName(name);
                AppUser savePerson = appUserRepository.save(user);
                return savePerson.getId();
            }


        }
        return -1L;
    }


    public List<AppUser> getUserList() {
        return appUserRepository.findAll();

    }


    public Optional<AppUser> editUser(Long id, EditAppUserDto dto) {

        Optional<AppUser> searchedUser = appUserRepository.findById(id);

        if (searchedUser.isPresent()) {

            AppUser user = searchedUser.get();


            user.setName(dto.getEdited_name());
            user.setSurname(dto.getEdited_surname());
            user.setDescriptionAcount(dto.getEdited_description());


            if (dto.getEdited_surname() != null) {
                user.setSurname(dto.getEdited_surname());
            }
            user = appUserRepository.save(user);


            return Optional.of(user);
        }

        return Optional.empty();
    }

    public Optional<AppUser> unregister(Long id, UnregisterDto dto) {

        if (id != null) {

            Optional<AppUser> searchedUser = appUserRepository.findById(id);
            if (searchedUser.isPresent()) {
                AppUser user = searchedUser.get();


                if (user.getPassword().equals(dto.getUnregister_password()) &&
                        user.getEmail().equals(dto.getUnregister_email())) {


                    appUserRepository.delete(user);


                    return Optional.of(user);
                }
            }
        }
        return Optional.empty();

    }
}
