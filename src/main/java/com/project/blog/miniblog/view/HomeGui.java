package com.project.blog.miniblog.view;

import com.vaadin.server.Sizeable;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI
public class HomeGui extends UI {

    @Autowired
    private Navigation navigation;


    @Override
    protected void init(VaadinRequest vaadinRequest) {
HorizontalLayout layout = new HorizontalLayout();
layout.addComponent(navigation.navBar());
setContent(layout);




}}
