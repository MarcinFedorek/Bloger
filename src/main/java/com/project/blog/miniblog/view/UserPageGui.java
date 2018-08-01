package com.project.blog.miniblog.view;


import com.project.blog.miniblog.view.IndexUri;
import com.project.blog.miniblog.view.nav.Navigation;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;



@SpringUI(path = IndexUri.user)
public class UserPageGui extends UI {

    @Autowired
    private Navigation navigation;



    @Override
    protected void init(VaadinRequest vaadinRequest) {




        VerticalLayout layout = new VerticalLayout();
        layout.addComponent(navigation.navBar());

        Panel panel = new Panel("Czy się zajmujemy");
        panel.setHeight(100.0f, Unit.PERCENTAGE);

        final VerticalLayout contentLayout = new VerticalLayout();
        contentLayout.setWidth(500, Unit.PIXELS);
        contentLayout.setSpacing(false);
        contentLayout.addComponent(new Label("Strona usera"));

        panel.setContent(contentLayout);
        layout.addComponent(panel);


        setContent(layout);


    }
}
