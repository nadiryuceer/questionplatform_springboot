package com.Nadir.cs393project.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToMany(mappedBy = "tags")
    private List<Question> questions;

    public Tag(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Question> getQuestions() {
        return questions;
    }
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    public void addQuestion(Question question){
        if(this.questions==null) this.questions = new ArrayList<>();
        this.questions.add(question);
    }
}
