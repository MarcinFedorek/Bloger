package com.project.blog.miniblog.view;

import com.vaadin.server.Sizeable;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.MenuBar;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI(path = "/home")
public class HomeGui extends UI {

    @Autowired
    private RegistrationForm registrationForm;


    @Autowired
    private EditUserGui editUserGui;



    @Override
    protected void init(VaadinRequest vaadinRequest) {

        HorizontalLayout layout = new HorizontalLayout();

        MenuBar menuBar = getMenuBar();

         layout.addComponent(menuBar);
         setContent(layout);
    }

    private MenuBar getMenuBar() {
        MenuBar menuBar = new MenuBar();
        menuBar.setWidth(100.0f, Unit.PERCENTAGE);

       // MenuBar.Command HomePage = selectedItem -> setContent(getFormWithMenuBar());
        MenuBar.Command menuCommand1 = selectedItem -> setContent(getFormWithMenuBar(registrationForm.getRegistrationForm()));


        menuBar.addItem("Zakladanie konta", menuCommand1);
//        menuBar.addItem("Edycja", menuCommand2);
        return menuBar;
    }

    private Layout getFormWithMenuBar(Layout layout) {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponent(getMenuBar() );
        horizontalLayout.addComponent(layout );
        return horizontalLayout;
    }


}
