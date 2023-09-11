package com.Nadir.askdeveloper.answer;

import com.Nadir.askdeveloper.comment.CommentforAnswer;
import com.Nadir.askdeveloper.question.Question;
import com.Nadir.askdeveloper.user.User;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private Date publishdate = new Date();
    private int votes=0;
    @ManyToOne
    @JoinColumn(name="username", nullable = false)
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
    public void addComment(CommentforAnswer comment){
        if(this.comments==null) this.comments = new ArrayList<>();
        this.comments.add(comment);
    }
}
