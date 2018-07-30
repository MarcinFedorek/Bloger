package com.project.blog.miniblog.view;

import com.project.blog.miniblog.model.postUser.PostUser;
import com.project.blog.miniblog.service.PostUserService;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WallGui extends Grid {
    @Autowired
    private PostUserService postUserService;


    public Layout getvLayout() {
        VerticalLayout vLayout = new VerticalLayout();



        ListDataProvider<PostUser> dataProvider = new ListDataProvider<>(postUserService.getPostList());
        Grid<PostUser> grid = new Grid<>();
        grid.addColumn(PostUser::getTitle).setId("Title").setCaption("Title");
        grid.addColumn(PostUser::getText);

        return vLayout;
    }



}
