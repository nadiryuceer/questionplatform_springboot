package com.Nadir.askdeveloper.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nickname;
    private String firstName;
    private String lastName;
    private String hashedPass;
    @OneToMany(mappedBy = "user")
    private List<Question> questions;
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
    @OneToMany(mappedBy = "user")
    private List<Answer> answers;

    public User(){

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public List<Question> getQuestions() {
        return questions;
    }
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    public List<Answer> getAnswers() {
        return answers;
    }
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
    public List<Comment> getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    public void addAnswer(Answer answer){
        if(this.answers==null) this.answers = new ArrayList<>();
        this.answers.add(answer);
    }
    public void addComment(Comment comment){
        if(this.comments==null) this.comments = new ArrayList<>();
        this.comments.add(comment);
    }
}
