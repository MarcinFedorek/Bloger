package com.project.blog.miniblog.view;

import com.project.blog.miniblog.model.AppUser.AppUser;
import com.project.blog.miniblog.repository.AppUserRepository;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditUserGui {

    @Autowired
    private AppUserRepository appUserRepository;


    public Layout getEditUserForm() {
        VerticalLayout components = new VerticalLayout();
        TextField descriptionAcount = new TextField("Acount name");
        TextField name = new TextField("Your Name");
        TextField surname = new TextField("Your Surname");
        Button updateButton = new Button("Update");

        updateButton.addClickListener(clickEvent -> {
            AppUser appUser = new AppUser();
            appUser.setDescriptionAcount(descriptionAcount.getValue());
            appUser.setName(name.getValue());
            appUser.setSurname(surname.getValue());
            appUserRepository.save(appUser);
        });


        components.addComponent(descriptionAcount);
        components.addComponent(name);
        components.addComponent(surname);
        components.addComponent(updateButton);

        return (components);
    }
}
