package com.Nadir.cs393project.dto.QuestionGetByIdWithDetails;

import com.Nadir.cs393project.model.User;

import javax.persistence.ManyToOne;
import java.util.Date;

public class CommentDTO {
    private int id;
    private String txt;
    private Date publishdate;
    private int votes;
    private String user;

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
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
}
