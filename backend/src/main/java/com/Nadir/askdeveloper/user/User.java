package com.Nadir.askdeveloper.user;

import com.Nadir.askdeveloper.answer.Answer;
import com.Nadir.askdeveloper.comment.Comment;
import com.Nadir.askdeveloper.question.Question;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User {
    @Id
    private String username;

    @Column(unique = true)
    private String email;
    private String firstname;
    private String lastname;
    //private String hashedPass;
    @OneToMany(mappedBy = "user")
    private List<Question> questions;
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
    @OneToMany(mappedBy = "user")
    private List<Answer> answers;

    public User(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
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
