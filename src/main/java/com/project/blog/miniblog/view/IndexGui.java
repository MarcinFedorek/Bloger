package com.project.blog.miniblog.view;


import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;


@SpringUI(path = "/in")
public class IndexGui extends UI {



    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Label title = new Label("Menu");
        title.addStyleName(ValoTheme.MENU_TITLE);

        Button view = new Button("Register", event -> Page.getCurrent().setLocation("/register"));
        view.addStyleNames(ValoTheme.BUTTON_LINK,ValoTheme.MENU_ITEM);

        Button view1 = new Button("User List", event -> Page.getCurrent().setLocation(IndexUri.userList));
        view1.addStyleNames(ValoTheme.BUTTON_LINK,ValoTheme.MENU_ITEM);

        Button view2 = new Button("Text List", event -> Page.getCurrent().setLocation(IndexUri.postList));
        view2.addStyleNames(ValoTheme.BUTTON_LINK,ValoTheme.MENU_ITEM);

        Button view3 = new Button("Add text", event -> Page.getCurrent().setLocation(IndexUri.addText));
        view3.addStyleNames(ValoTheme.BUTTON_LINK,ValoTheme.MENU_ITEM);

        Button view4 = new Button("Text List", event -> Page.getCurrent().setLocation(IndexUri.editUser));
        view4.addStyleNames(ValoTheme.BUTTON_LINK,ValoTheme.MENU_ITEM);

        CssLayout css = new CssLayout(title, view,view1,view2,view3,view4);
        css.addStyleName(ValoTheme.MENU_ROOT);

        CssLayout viewContent = new CssLayout();

        HorizontalLayout mainLayout = new HorizontalLayout(css, viewContent);
        mainLayout.setSizeFull();
        setContent(mainLayout);

        Navigator navigator = new Navigator(this,viewContent);
        navigator.addView("",DefaultView.class);
        navigator.addView("login", Login.class);


    }
}
