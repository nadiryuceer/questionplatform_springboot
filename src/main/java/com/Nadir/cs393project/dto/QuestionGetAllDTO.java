package com.Nadir.cs393project.dto;

import java.util.Date;
import java.util.List;

public class QuestionGetAllDTO {
    private String title;
    private String descript;
    private List<String> tagnames;
    private Date publishdate;
    private String askedby;
    private int answercount;
    private int votes;

    public QuestionGetAllDTO() {}

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
    public int getAnswercount() {
        return answercount;
    }
    public void setAnswercount(int answercount) {
        this.answercount = answercount;
    }
    public List<String> getTagnames() {
        return tagnames;
    }
    public void setTagnames(List<String> tagnames) {
        this.tagnames = tagnames;
    }
    public int getVotes() {
        return votes;
    }
    public void setVotes(int votes) {
        this.votes = votes;
    }
    public String getAskedby() {
        return askedby;
    }
    public void setAskedby(String askedby) {
        this.askedby = askedby;
    }
}