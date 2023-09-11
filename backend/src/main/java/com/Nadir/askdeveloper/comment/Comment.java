package com.Nadir.askdeveloper.comment;

import com.Nadir.askdeveloper.user.User;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Date;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Table(name = "comments")
@DiscriminatorColumn(name = "CM_TYPE", length = 5)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private Date publishdate=new Date();
    private int votes=0;
    @ManyToOne
    @JoinColumn(name="username", nullable = false)
    private User user;

    public Comment(){}

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
