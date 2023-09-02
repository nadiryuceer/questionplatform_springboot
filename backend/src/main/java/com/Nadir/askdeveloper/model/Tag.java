package com.Nadir.askdeveloper.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Tag {
    @Id
    private String name;
    @ManyToMany(mappedBy = "tags")
    private List<Question> questions;

    public Tag(){}

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
