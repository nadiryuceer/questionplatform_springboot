package com.Nadir.cs393project.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String txt;
    private Date publishdate = new Date();
    private int votes=0;
    @ManyToOne
    private User user;
    @ManyToOne
    private Question question;
    @OneToMany(mappedBy = "answer")
    private List<CommentforAnswer> comments;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTxt() {
        return txt;
    }
    public void setTxt(String txt) {
        this.txt = txt;
    }
    public Date getPublishdate() {
        return publishdate;
    }
    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }
    public int getVotes() {
        return votes;
    }
    public void setVotes(int votes) {
        this.votes = votes;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Question getQuestion() {
        return question;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }
    public List<CommentforAnswer> getComments() {
        return comments;
    }
    public void setComments(List<CommentforAnswer> comments) {
        this.comments = comments;
    }
}
