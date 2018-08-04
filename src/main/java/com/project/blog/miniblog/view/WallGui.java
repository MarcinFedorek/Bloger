package com.project.blog.miniblog.view;

import com.project.blog.miniblog.model.postUser.PostUser;
import com.project.blog.miniblog.service.PostUserService;
import com.project.blog.miniblog.view.nav.LoggedNav;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WallGui extends Grid {
    @Autowired
    private PostUserService postUserService;

    @Autowired
    private LoggedNav loggedNav;


    public Layout getLayout() {
        VerticalLayout layout = new VerticalLayout();
        //layout.addComponent(loggedNav.navBar("id"));


//
//        ListDataProvider<PostUser> dataProvider = new ListDataProvider<>(postUserService.getPostList());
//        Grid<PostUser> grid = new Grid<>();
//        grid.setDataProvider(dataProvider);
//        grid.addColumn(PostUser::getTitle).setId("Title").setCaption("Title");
//        grid.addColumn(PostUser::getText).setCaption("Text");


//        layout.addComponent(grid);

        return layout;
    }



}
