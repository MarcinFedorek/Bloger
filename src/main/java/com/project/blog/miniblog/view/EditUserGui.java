package com.project.blog.miniblog.view;

import com.project.blog.miniblog.model.AppUser.AppUser;
import com.project.blog.miniblog.model.dto.userDto.EditAppUserDto;
import com.project.blog.miniblog.repository.AppUserRepository;
import com.project.blog.miniblog.service.AppUserService;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditUserGui {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppUserService appUserService;


    public Layout getEditUserForm() {
        VerticalLayout components = new VerticalLayout();
        TextField descriptionAcount = new TextField("Acount name");
        TextField name = new TextField("Your Name");
        TextField surname = new TextField("Your Surname");
        Button updateButton = new Button("Update");

        updateButton.addClickListener(clickEvent -> {
            EditAppUserDto dto = new EditAppUserDto();
            Long id = dto.getEdited_id;
            appUserService.editUser(id , dto);
//            AppUser appUser = new AppUser();
//            appUser.setDescriptionAcount(descriptionAcount.getValue());
//            appUser.setName(name.getValue());
//            appUser.setSurname(surname.getValue());
//            appUserRepository.save(appUser);
        });


        components.addComponent(descriptionAcount);
        components.addComponent(name);
        components.addComponent(surname);
        components.addComponent(updateButton);

        return (components);
    }
}
