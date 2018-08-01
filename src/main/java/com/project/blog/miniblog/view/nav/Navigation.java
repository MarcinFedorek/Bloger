package com.project.blog.miniblog.view.nav;

import com.project.blog.miniblog.view.IndexUri;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;

import com.vaadin.ui.MenuBar;
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
        Link link2 = new Link("User List", new ExternalResource(IndexUri.userList));

        Label postList = new Label();
        postList.setStyleName("link");
        Link post = new Link("Posts List", new ExternalResource(IndexUri.postList));


        Label postLabel = new Label();
        postLabel.setStyleName("link");
        Link link3 = new Link("Log in", new ExternalResource(IndexUri.logged));

        Label registrationLabel = new Label();
        registrationLabel.setStyleName("link");
        Link link4 = new Link("Register", new ExternalResource(IndexUri.register));


        menulayout.addComponent(indexLabel);
        menulayout.addComponent(usersLabel);
        menulayout.addComponent(postLabel);
        menulayout.addComponent(postList);
        menulayout.addComponent(registrationLabel);
        menulayout.addComponent(link1);
        menulayout.addComponent(link2);
        menulayout.addComponent(post);
        menulayout.addComponent(link3);
        menulayout.addComponent(link4);



        return menulayout;

    }


}