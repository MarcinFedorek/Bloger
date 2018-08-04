package com.project.blog.miniblog.view;

import com.project.blog.miniblog.model.postUser.PostUser;
import com.project.blog.miniblog.service.PostUserService;
import com.project.blog.miniblog.view.IndexUri;
import com.project.blog.miniblog.view.nav.Navigation;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI(path = IndexUri.postList)
public class PostsList extends UI {

    @Autowired
    private Navigation navigation;

    @Autowired
    private PostUserService postUserService;

    @Autowired
    public PostsList(PostUserService postUserService){
        this.postUserService = postUserService;
    }


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout = new VerticalLayout();

        String userId = vaadinRequest.getParameter("userId");
        layout.addComponent(navigation.navBar());



        ListDataProvider<PostUser> dataProvider = new ListDataProvider<>(postUserService.getPostList());
        Grid<PostUser> grid = new Grid<>();
        grid.setDataProvider(dataProvider);

        grid.addColumn(PostUser::getId).setCaption("Id");
        grid.addColumn(PostUser::getTitle).setCaption("Title");
        grid.addColumn(PostUser::getText).setCaption("Text");


        layout.addComponent(grid);
        setContent(layout);

    }
}
