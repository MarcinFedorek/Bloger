package com.project.blog.miniblog.view;

import com.vaadin.navigator.View;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Label;

public class Viewq extends Composite implements View {

    public Viewq(){
        setCompositionRoot(new Label("This is view q"));
    }
}
