package com.Nadir.cs393project.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Table(name = "Comment")
@DiscriminatorColumn(name = "CM_TYPE", length = 5)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String txt;
    private Date publishdate=new Date();
    private int votes=0;
    @ManyToOne
    private User user;

    public Comment(){}

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
    public int getVotes() {
        return votes;
    }
    public void setVotes(int votes) {
        this.votes = votes;
    }
    public Date getPublishdate() {
        return publishdate;
    }
    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
