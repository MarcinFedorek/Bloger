package com.project.blog.miniblog.view;


import com.vaadin.navigator.Navigator;
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

        Button view = new Button("login", event -> getNavigator().navigateTo("login"));
        view.addStyleNames(ValoTheme.BUTTON_LINK,ValoTheme.MENU_ITEM);

        CssLayout css = new CssLayout(title, view);
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
