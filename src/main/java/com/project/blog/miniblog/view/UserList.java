package com.project.blog.miniblog.view;

import com.project.blog.miniblog.model.AppUser.AppUser;
import com.project.blog.miniblog.service.AppUserService;
import com.project.blog.miniblog.view.nav.LoggedNav;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;

import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI(path = IndexUri.userList)
public class UserList extends UI {
    @Autowired
    private LoggedNav loggedNav;

    @Autowired
    private AppUserService appUserService;
    @Autowired
    public UserList(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout = new VerticalLayout();
        layout.addComponent(loggedNav.navBar());
        ListDataProvider<AppUser> dataProvider = new ListDataProvider<>(appUserService.getUserList());
        Grid<AppUser> grid = new Grid<>();
        grid.setDataProvider(dataProvider);
        grid.addColumn(AppUser::getName).setId("Name").setCaption("Name");
        grid.addColumn(AppUser::getEmail).setId("Email").setCaption("Email");
        layout.addComponent(grid);

        setContent(layout);


    }
}