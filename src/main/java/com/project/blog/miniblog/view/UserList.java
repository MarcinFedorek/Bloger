package com.project.blog.miniblog.view;

import com.project.blog.miniblog.model.AppUser.AppUser;
import com.project.blog.miniblog.service.AppUserService;
import com.project.blog.miniblog.view.nav.LoggedNav;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

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

    @Autowired
    WallGui wallGui;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout = new VerticalLayout();

        String userId = vaadinRequest.getParameter("userId");
        layout.addComponent(loggedNav.navBar("?userId=" + userId));


        ListDataProvider<AppUser> dataProvider = new ListDataProvider<>(appUserService.getUserList());
        Grid<AppUser> grid = new Grid<>();
        grid.setDataProvider(dataProvider);
        grid.addColumn(AppUser::getId).setId("Id").setCaption("Id");
        grid.addColumn(AppUser::getName).setId("Name").setCaption("Name");
        grid.addColumn(AppUser::getEmail).setId("Email").setCaption("Email");
        grid.addColumn(AppUser::getSurname).setId("Surname").setCaption("Surname");
        grid.addColumn(AppUser::getAccountStatus).setId("Status").setCaption("Status");

        Button buttonRemove = new Button("Remove");

        buttonRemove.addClickListener(event -> {
            Set<AppUser> selectedItems = grid.getSelectedItems();
            for (AppUser selectedItem : selectedItems) {
                appUserService.unregister(selectedItem.getId());
            }
            grid.setDataProvider(dataProvider);
            Page.getCurrent().open(IndexUri.userList + "?userId=" + userId, null);
        });
        //dodac to logged page
        layout.addComponent(wallGui.getLayout());
        layout.addComponent(grid);
        layout.addComponent(buttonRemove);
        setContent(layout);
    }
}