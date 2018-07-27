package com.project.blog.miniblog.view.nav;

import com.project.blog.miniblog.view.IndexUri;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import org.springframework.stereotype.Service;

@Service
public class LoggedNav {
    public HorizontalLayout navBar(String userId) {
        HorizontalLayout menulayout = new HorizontalLayout();
        menulayout.setMargin(true);
        menulayout.setSpacing(true);

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSpacing(true);

        Label indexLabel = new Label();
        indexLabel.setStyleName("link");
        Link link1 = new Link("Home", new ExternalResource(IndexUri.home + userId));

        Label usersLabel = new Label();
        usersLabel.setStyleName("link");
        Link link2 = new Link("User List", new ExternalResource(IndexUri.userList+ userId));


        Label postLabel = new Label();
        postLabel.setStyleName("link");
        Link link3 = new Link("Add text", new ExternalResource(IndexUri.addText+ userId));


        Label editLabel = new Label();
        postLabel.setStyleName("edit");
        Link link4 = new Link("Edit My Account", new ExternalResource(IndexUri.editUser+ userId));


        menulayout.addComponent(indexLabel);
        menulayout.addComponent(usersLabel);
        menulayout.addComponent(postLabel);
        menulayout.addComponent(editLabel);
        menulayout.addComponent(link1);
        menulayout.addComponent(link2);
        menulayout.addComponent(link3);
        menulayout.addComponentsAndExpand(link4);
        return menulayout;
}}
