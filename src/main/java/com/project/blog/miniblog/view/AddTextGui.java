package com.project.blog.miniblog.view;

import com.project.blog.miniblog.service.PostUserService;
import com.project.blog.miniblog.view.nav.LoggedNav;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI(path = IndexUri.addText)
public class AddTextGui extends UI {

    @Autowired
    private PostUserService postUserService;

    @Autowired
    private LoggedNav loggedNav;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout = new VerticalLayout();
        String userId = vaadinRequest.getParameter("userId");

        layout.addComponent(loggedNav.navBar("?userId=" + userId));

        TextArea textArea = new TextArea();
        Button button = new Button("Add text");

        layout.addComponent(textArea);
        layout.addComponent(button);
        setContent(layout);
    }




}
