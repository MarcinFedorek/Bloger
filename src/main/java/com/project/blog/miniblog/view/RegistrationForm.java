package com.project.blog.miniblog.view;


import com.project.blog.miniblog.service.AppUserService;
import com.vaadin.server.Page;

import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistrationForm {

    @Autowired
    private AppUserService appUserService;

    public Layout getRegistrationForm() {
        VerticalLayout components = new VerticalLayout();
        TextField email = new TextField("email");
        TextField password = new TextField("password");
        TextField descriptionAcount = new TextField("Acount name");
        Button registerButton = new Button("Register");
        // CssLayout layout = new CssLayout();


        registerButton.addClickListener(event ->
                {
                    Long userId = appUserService.registerUser(email.getValue(),
                            password.getValue());
                    if (userId > 0) {
                        Page.getCurrent().open("/user-data?userId=" + userId, null);
                        Notification.show(
                                "User added",
                                Notification.Type.TRAY_NOTIFICATION);
                    } else {
                        Notification.show(
                                "Problem",
                                Notification.Type.ERROR_MESSAGE);
                    }
                }
        );

        components.addComponent(email);
        components.addComponent(password);
        components.addComponent(descriptionAcount);
        components.addComponent(registerButton);
        return components;
    }
}
