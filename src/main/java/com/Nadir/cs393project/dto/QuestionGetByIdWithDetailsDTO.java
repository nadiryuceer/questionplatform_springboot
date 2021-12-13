package com.Nadir.cs393project.dto;

import com.Nadir.cs393project.model.Answer;
import com.Nadir.cs393project.model.CommentforQuestion;
import com.Nadir.cs393project.model.User;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

public class QuestionGetByIdWithDetailsDTO {
    private int id;
    private String title;
    private String descript;
    private Date publishdate;
    private int views;
    private int votes;
    private List<CommentforQuestion> comments;
    private List<Answer> answers;
    private User user;

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
}
