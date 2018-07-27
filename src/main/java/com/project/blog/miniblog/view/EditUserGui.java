package com.project.blog.miniblog.view;


import com.project.blog.miniblog.model.AppUser.AppUser;
import com.project.blog.miniblog.repository.AppUserRepository;
import com.project.blog.miniblog.service.AppUserService;
import com.project.blog.miniblog.view.nav.LoggedNav;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI(path = IndexUri.editUser+"userId")
public class EditUserGui extends UI {

    @Autowired
    private LoggedNav loggedNav;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout components = new VerticalLayout();
        TextField name = new TextField("Your Name");
        TextField surname = new TextField("Your Surname");
        TextField descriptionAcount = new TextField("Acount name");
        Button updateButton = new Button("Update");

        updateButton.addClickListener(clickEvent -> {

        Long userId = Long.parseLong(vaadinRequest.getParameter(IndexUri.editUser+"userId"));
        AppUser personById = appUserService.getPersonById(userId);
                    boolean updateComplete = appUserService.editUser(userId, name.getValue(), surname.getValue(),
                            descriptionAcount.getValue());
                    if (updateComplete) {
                        Notification.show("Update complete", Notification.Type.TRAY_NOTIFICATION);
                    } else {
                        Notification.show("Problem :(", Notification.Type.ERROR_MESSAGE);
                    }









            Notification.show("Edited Account", Notification.Type.TRAY_NOTIFICATION);
            Page.getCurrent().setLocation(IndexUri.logged);


        });

        components.addComponent(loggedNav.navBar());
        components.addComponent(name);
        components.addComponent(surname);
        components.addComponent(descriptionAcount);
        components.addComponent(updateButton);


        setContent(components);


    }
}


