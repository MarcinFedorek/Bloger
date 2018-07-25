package com.project.blog.miniblog;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


@SpringUI
public class BlogGui extends UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout components = new VerticalLayout();
        TextField email = new TextField("email");
        TextField password = new TextField("password");
        TextField acountName = new TextField("Acount name");
        Button registerButton = new Button();

        components.addComponent(email);
        components.addComponent(password);
        components.addComponent(acountName);
        components.addComponent(registerButton);

        setContent(components);



    }
}
