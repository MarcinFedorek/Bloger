package com.project.blog.miniblog.view;

import com.project.blog.miniblog.view.IndexUri;
import com.project.blog.miniblog.view.WallGui;
import com.project.blog.miniblog.view.nav.LoggedNav;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI(path = IndexUri.LOGGEDPAGE)
public class HomeLoggedGui extends UI {

    @Autowired
    private LoggedNav loggedNav;

    @Autowired
    private WallGui wallGui;
    @Override
    protected void init(VaadinRequest request) {

        VerticalLayout layout = new VerticalLayout();
        Long userId = Long.parseLong(request.getParameter("userId"));

        layout.addComponent(loggedNav.navBar("?userId=" + userId));
        layout.addComponent(wallGui);

        setContent(layout);

    }
}
