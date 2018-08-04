package com.project.blog.miniblog.view;


import com.project.blog.miniblog.model.AppUser.TypeOfAccount;
import com.project.blog.miniblog.service.AppUserService;
import com.project.blog.miniblog.view.IndexUri;
import com.project.blog.miniblog.view.nav.Navigation;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;



@SpringUI(path = "register")
public class RegistrationGui extends UI implements View {



//    @Autowired
//    IndexGui indexGui;
@Autowired
private Navigation navigation;


    @Autowired
    private AppUserService appUserService;

//    @Override
//    protected void init(VaadinRequest vaadinRequest) {

//
//
//        Label title = new Label("Menu");
//        title.addStyleName(ValoTheme.MENU_TITLE);
//
//        Button view = new Button("Register", event -> Page.getCurrent().setLocation("/register"));
//        view.addStyleNames(ValoTheme.BUTTON_LINK,ValoTheme.MENU_ITEM);
//
//        Button view1 = new Button("User List", event -> Page.getCurrent().setLocation(IndexUri.userList));
//        view1.addStyleNames(ValoTheme.BUTTON_LINK,ValoTheme.MENU_ITEM);
//
//        Button view2 = new Button("Text List", event -> Page.getCurrent().setLocation(IndexUri.postList));
//        view2.addStyleNames(ValoTheme.BUTTON_LINK,ValoTheme.MENU_ITEM);
//
//        Button view3 = new Button("Add text", event -> Page.getCurrent().setLocation(IndexUri.addText));
//        view3.addStyleNames(ValoTheme.BUTTON_LINK,ValoTheme.MENU_ITEM);
//
//        Button view4 = new Button("Text List", event -> Page.getCurrent().setLocation(IndexUri.editUser));
//        view4.addStyleNames(ValoTheme.BUTTON_LINK,ValoTheme.MENU_ITEM);
//
//        CssLayout css = new CssLayout(title, view,view1,view2,view3,view4);
//        css.addStyleName(ValoTheme.MENU_ROOT);
//
//        CssLayout viewContent = new CssLayout();
//
//        HorizontalLayout mainLayout = new HorizontalLayout(css, viewContent);
//        mainLayout.setSizeFull();
//        setContent(mainLayout);
//
//        Navigator navigator = new Navigator(this,viewContent);
//        navigator.addView("",DefaultView.class);
//        navigator.addView("login", Login.class);
//
//        VerticalLayout components = new VerticalLayout();
//        TextField email = new TextField("email");
//        TextField password = new TextField("password");
//        TextField name = new TextField("Acount name");;
//
//        Button registerButton = new Button("Register");
//
//        registerButton.addClickListener(event -> {
//            Long userId = appUserService.registerUser(email.getValue(),
//                    password.getValue(), name.getValue());
//            if (userId > 0) {
//                Page.getCurrent().open(IndexUri.logged + "?userId=" + userId, null);
//                Notification.show(
//                        "User added",
//                        Notification.Type.TRAY_NOTIFICATION);
//            } else {
//                Notification.show(
//                        "Problem",
//                        Notification.Type.ERROR_MESSAGE);
//            }
//
//
//            Notification.show("Acount created", Notification.Type.TRAY_NOTIFICATION);
//            Page.getCurrent().setLocation(IndexUri.logged);
//
//        });
//
//
//
//        components.addComponent(indexGui);
//        components.addComponent(email);
//        components.addComponent(password);
//        components.addComponent(name);
//        components.addComponent(registerButton);
//        components.addComponent(mainLayout);
//        setContent(components);
//
//    }}

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout components = new VerticalLayout();
        TextField email = new TextField("email");
        TextField password = new TextField("password");
        TextField name = new TextField("Acount name");



        Button registerButton = new Button("Register");



        registerButton.addClickListener(event -> {
            Long userId = appUserService.registerUser(email.getValue(),
                    password.getValue(), name.getValue());
            if (userId > 0) {
                Page.getCurrent().open(IndexUri.logged + "?userId=" + userId, null);
                Notification.show(
                        "User added",
                        Notification.Type.TRAY_NOTIFICATION);
            } else {
                Notification.show(
                        "Problem",
                        Notification.Type.ERROR_MESSAGE);
            }


            Notification.show("Acount created", Notification.Type.TRAY_NOTIFICATION);
            Page.getCurrent().setLocation(IndexUri.logged);

        });

        components.addComponent(navigation.navBar());
        components.addComponent(email);
        components.addComponent(password);
        components.addComponent(name);
        components.addComponent(registerButton);
       // components.addComponent(indexGui);
        setContent(components);


    }
}
