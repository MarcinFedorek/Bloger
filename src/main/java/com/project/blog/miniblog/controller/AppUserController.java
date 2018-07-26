package com.project.blog.miniblog.controller;

import com.project.blog.miniblog.model.AppUser.AppUser;
import com.project.blog.miniblog.model.dto.userDto.*;
import com.project.blog.miniblog.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/index")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/registerUser")
    public void registerUser(@RequestBody RegisterUserDto dto) {
        appUserService.registerUser(dto);
    }

    @PostMapping("/unregister")
    public ResponseEntity<DeleteUserDto> unRegisterUser(@RequestBody UnregisterDto dto){
    Optional<AppUser>removeUser = appUserService.unregister(dto.getUnregister_id(),dto);
        if (removeUser.isPresent()) {
            return ResponseEntity.ok(new DeleteUserDto(removeUser.get()));
        }
        return ResponseEntity.badRequest().build();

    }


    @PostMapping("/edit/{id}")
    public ResponseEntity<AppUser> editUser(@PathVariable(name = "id") Long id,
                                            @RequestBody EditAppUserDto dto) {
        Optional<AppUser> editAppUser = appUserService.editUser(id, dto);

        if (editAppUser.isPresent()) {

            return ResponseEntity.ok(editAppUser.get());
        }

        return ResponseEntity.badRequest().build();

    }


    @GetMapping("/listUsers")
    public ResponseEntity<List<AppUserDto>> listUsers() {
        return ResponseEntity.ok(appUserService.getUserList());
    }

}
