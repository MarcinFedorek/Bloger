package com.project.blog.miniblog.view.nav;

import com.project.blog.miniblog.view.IndexUri;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;

import org.springframework.stereotype.Service;

@Service
public class Navigation {


    public HorizontalLayout navBar() {
        HorizontalLayout menulayout = new HorizontalLayout();
        menulayout.setMargin(true);
        menulayout.setSpacing(true);

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSpacing(true);

        Label indexLabel = new Label();
        indexLabel.setStyleName("link");
        Link link1 = new Link("Home", new ExternalResource(IndexUri.home));

        Label usersLabel = new Label();
        usersLabel.setStyleName("link");
        Link link2 = new Link("Users List", new ExternalResource("/userlist"));


        Label postLabel = new Label();
        postLabel.setStyleName("link");
        Link link3 = new Link("Post List", new ExternalResource("/post_list"));

        Label registrationLabel = new Label();
        registrationLabel.setStyleName("link");
        Link link4 = new Link("Register", new ExternalResource("/register"));

        Label loginLabel = new Label();
        loginLabel.setStyleName("link");
        Link link5 = new Link("Sing in", new ExternalResource(IndexUri.register));


        menulayout.addComponent(indexLabel);
        menulayout.addComponent(usersLabel);
        menulayout.addComponent(postLabel);
        menulayout.addComponent(registrationLabel);
        menulayout.addComponent(loginLabel);
        menulayout.addComponent(link1);
        menulayout.addComponent(link2);
        menulayout.addComponent(link3);
        menulayout.addComponent(link4);
        menulayout.addComponent(link5);
        return menulayout;
    }


}