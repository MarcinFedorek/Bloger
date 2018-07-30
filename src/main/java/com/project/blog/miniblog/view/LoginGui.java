package com.project.blog.miniblog.view;

import com.project.blog.miniblog.model.AppUser.AppUser;
import com.project.blog.miniblog.repository.AppUserRepository;
import com.project.blog.miniblog.service.AppUserService;
import com.project.blog.miniblog.view.nav.Navigation;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
@SpringUI(path = IndexUri.logged)
public class LoginGui extends UI {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private Navigation navigation;
    @Autowired
    private AppUserRepository appUserRepository;


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout = new VerticalLayout();
        TextField email = new TextField("email");
        TextField password = new TextField("password");
        Button loginButton = new Button("Login");

        loginButton.addClickListener(event->{
            Optional<AppUser> user = Optional.ofNullable(appUserService.getPersonByEmail(email.getValue()));

            if (user.isPresent()){
                if (user.get().getPassword().equals(password.getValue())) {

                    Notification.show("Hello " + user.get().getName(), Notification.Type.TRAY_NOTIFICATION);
                    Page.getCurrent().open("?userId=" + user.get().getId(), null);

                } else {
                    Notification.show("Incorrect password!", Notification.Type.ERROR_MESSAGE);
                }


            } else {
                Notification.show("Cannot find the user", Notification.Type.ERROR_MESSAGE);
                Page.getCurrent().open("/register", null);
            }

        }

         );

        layout.addComponent(navigation.navBar());
        layout.addComponent(email);
        layout.addComponent(password);
        layout.addComponent(loginButton);


        setContent(layout);
    }
}
