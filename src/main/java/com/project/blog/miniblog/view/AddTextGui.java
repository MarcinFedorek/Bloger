package com.project.blog.miniblog.view;

import com.project.blog.miniblog.model.postUser.PostUser;
import com.project.blog.miniblog.service.PostUserService;
import com.project.blog.miniblog.view.nav.LoggedNav;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import jdk.internal.util.xml.impl.Input;
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
        Label label = new Label();
        label.setCaption("Title");
        TextField title = new TextField();
        TextArea textArea = new TextArea();
        Button button = new Button("Add text");
        button.addClickListener(event -> {
            PostUser postUser = new PostUser();
            postUser.setTitle(title.getValue());
            postUser.setText(textArea.getValue());
            postUserService.addPost(postUser);
        });
        layout.addComponent(label);
        layout.addComponent(title);
        layout.addComponent(textArea);
        layout.addComponent(button);
        setContent(layout);
    }


}
