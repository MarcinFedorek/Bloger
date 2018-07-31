package com.project.blog.miniblog.view.view2;

import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;


@SpringUI(path = "/admin")
@Title("LoginPage")
public class AdminUI  extends UI{

    @Override
    protected void init(VaadinRequest request) {
        setContent(new Label("Hello! I'm the admin UI!"));
    }

}