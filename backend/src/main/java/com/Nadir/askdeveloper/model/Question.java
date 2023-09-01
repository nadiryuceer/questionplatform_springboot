package com.Nadir.askdeveloper.model;


import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private Date publishdate = new Date();
    private int views=0;
    private int votes=0;
    @OneToMany(mappedBy = "question")
    private List<CommentforQuestion> comments;
    @OneToMany(mappedBy = "question")
    private List<Answer> answers;
    @ManyToOne
    @JoinColumn(name="username", nullable = false)
    private User user;
    @ManyToMany
    @JoinTable(joinColumns =
        @JoinColumn(name = "question_id",referencedColumnName = "id"),
        inverseJoinColumns =
        @JoinColumn(name = "tag_id",referencedColumnName = "id"))
    private List<Tag> tags;

    public Question() {

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishdate() {
        return publishdate;
    }
    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public int getViews() {
        return views;
    }
    public void setViews(int views) {
        this.views = views;
    }
    public int getVotes() {
        return votes;
    }
    public void setVotes(int votes) {
        this.votes = votes;
    }
    public List<CommentforQuestion> getComments() {
        return comments;
    }
    public void setComments(List<CommentforQuestion> comments) {
        this.comments = comments;
    }
    public List<Answer> getAnswers() {
        return answers;
    }
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public List<Tag> getTags() {
        return tags;
    }
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    public void addAnswer(Answer answer){
        if(this.answers==null) this.answers = new ArrayList<>();
        this.answers.add(answer);
    }
    public void addComment(CommentforQuestion comment){
        if(this.comments==null) this.comments = new ArrayList<>();
        this.comments.add(comment);
    }
}
