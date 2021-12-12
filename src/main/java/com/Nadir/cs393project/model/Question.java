package com.Nadir.cs393project.model;


import javax.persistence.*;
import java.util.List;
import java.util.Date;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String descript;
    private Date publishdate;
    private int views;
    private int votes;
    @OneToMany(mappedBy = "question")
    private List<CommentforQuestion> comments;
    @OneToMany(mappedBy = "question")
    private List<Answer> answers;
    @ManyToOne
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
    public String getDescript() {
        return descript;
    }
    public void setDescript(String descript) {
        this.descript = descript;
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
}
