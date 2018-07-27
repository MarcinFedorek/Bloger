package com.project.blog.miniblog.view;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import org.springframework.stereotype.Service;

@Service
public class LoggedNav {
    public HorizontalLayout navBar() {
        HorizontalLayout menulayout = new HorizontalLayout();
        menulayout.setMargin(true);
        menulayout.setSpacing(true);

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSpacing(true);

        Label indexLabel = new Label();
        indexLabel.setStyleName("link");
        Link link1 = new Link("Home", new ExternalResource("/index"));

        Label usersLabel = new Label();
        usersLabel.setStyleName("link");
        Link link2 = new Link("Users List", new ExternalResource("/list_users"));


        Label postLabel = new Label();
        postLabel.setStyleName("link");
        Link link3 = new Link("Add text", new ExternalResource("/add_text"));


        menulayout.addComponent(indexLabel);
        menulayout.addComponent(usersLabel);
        menulayout.addComponent(postLabel);
        menulayout.addComponent(link1);
        menulayout.addComponent(link2);
        menulayout.addComponent(link3);
        return menulayout;
}}
