package com.project.blog.miniblog.view;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

@SpringUI(path = "index")
public class Index extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        HorizontalLayout menulayout = new HorizontalLayout();
        menulayout.setMargin(true);
        menulayout.setSpacing(true);

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSpacing(true);

        Label indexLabel = new Label("Home");
        Label usersLabel = new Label("Users List");
        Label postLabel = new Label("Users List");


        menulayout.addComponent(indexLabel);
        menulayout.addComponent(usersLabel);
        menulayout.addComponent(postLabel);
        setContent(menulayout);
    }


}
