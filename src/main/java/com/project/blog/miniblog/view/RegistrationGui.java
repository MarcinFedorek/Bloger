package com.project.blog.miniblog.view;

import com.project.blog.miniblog.repository.AppUserRepository;
import com.project.blog.miniblog.service.AppUserService;
import com.project.blog.miniblog.view.nav.Navigation;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI(path = "register")
public class RegistrationGui extends UI {

    @Autowired
    private Navigation navigation;


    @Autowired
    private AppUserService appUserService;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout components = new VerticalLayout();
        TextField email = new TextField("email");
        TextField password = new TextField("password");
        TextField name = new TextField("Acount name");
        Button registerButton = new Button("Register");
       // CssLayout layout = new CssLayout();



        registerButton.addClickListener(event -> {
            Long userId = appUserService.registerUser(email.getValue(),
                    password.getValue(),name.getValue());
            if (userId > 0) {
                Page.getCurrent().open( IndexUri.logged+userId, null);
                Notification.show(
                        "User added",
                        Notification.Type.TRAY_NOTIFICATION);
            } else {
                Notification.show(
                        "Problem",
                        Notification.Type.ERROR_MESSAGE);
            }


            Notification.show("Acount created", Notification.Type.TRAY_NOTIFICATION);
            Page.getCurrent().setLocation(IndexUri.logged);

        });

        components.addComponent(navigation.navBar());
        components.addComponent(email);
        components.addComponent(password);
        components.addComponent(name);
        components.addComponent(registerButton);

        setContent(components);



    }
}
