package com.project.blog.miniblog.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class DefaultView extends Composite implements View {

    public DefaultView() {
        setCompositionRoot(new Label("Login")
        );
    }

}