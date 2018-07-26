package com.project.blog.miniblog.view;

import com.project.blog.miniblog.model.AppUser.AppUser;
import com.project.blog.miniblog.repository.AppUserRepository;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI(path = "register")
public class RegistrationGui extends UI {
    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout components = new VerticalLayout();
        TextField email = new TextField("email");
        TextField password = new TextField("password");
        TextField descriptionAcount = new TextField("Acount name");
        Button registerButton = new Button("Register");
       // CssLayout layout = new CssLayout();



        registerButton.addClickListener(event -> {
            AppUser appUser = new AppUser();
            appUser.setEmail(email.getValue());
            appUser.setPassword(password.getValue());
            appUser.setName(descriptionAcount.getValue());

            appUserRepository.save(appUser);
            Notification.show("Acount created", Notification.Type.TRAY_NOTIFICATION);
        });

        components.addComponent(email);
        components.addComponent(password);
        components.addComponent(descriptionAcount);
        components.addComponent(registerButton);

        setContent(components);



    }
}
