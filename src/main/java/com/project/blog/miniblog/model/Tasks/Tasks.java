package com.project.blog.miniblog.model.Tasks;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String text;
    private boolean done;

    public Tasks() {
    }

    public Tasks(String text, boolean done) {
        this.text = text;
        this.done = done;
    }
}
