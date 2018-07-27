package com.project.blog.miniblog.view;


import com.project.blog.miniblog.repository.AppUserRepository;
import com.project.blog.miniblog.view.nav.LoggedNav;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI(path = IndexUri.logged)
public class UserPageGui extends UI {

    @Autowired
    private LoggedNav loggedNav;

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout components = new VerticalLayout();
        components.addComponent(loggedNav.navBar());




        Label label = new Label("zalogowany");
        components.addComponent(label);


        setContent(components);


    }
}
