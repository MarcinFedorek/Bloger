package com.project.blog.miniblog.view;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.UI;

@SpringUI(path = "index")
public class Index extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        HorizontalLayout menulayout = new HorizontalLayout();
        menulayout.setMargin(true);
        menulayout.setSpacing(true);

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSpacing(true);

        Label indexLabel = new Label();
        indexLabel.setStyleName("link");
        Link link1 = new Link("Home",new ExternalResource("/index"));

        Label usersLabel = new Label();
        usersLabel.setStyleName("link");
        Link link2 = new Link("Users List",new ExternalResource("/users_list"));


        Label postLabel = new Label();
        postLabel.setStyleName("link");
        Link link3 = new Link("Post List", new ExternalResource("/post_list"));

        Label registrationLabel = new Label();
        registrationLabel.setStyleName("link");
       Link link4 = new Link("Register",new ExternalResource("/registrationForm"));

        Label loginLabel = new Label();
        loginLabel.setStyleName("link");
        Link link5 = new Link("Sing in",new ExternalResource("/Sing_in"));



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
        setContent(menulayout);
    }


}
