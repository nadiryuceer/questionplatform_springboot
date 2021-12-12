package com.Nadir.cs393project.dto;

public class QuestionCommentSaveDTO {
    String txt;
    int userid;
    int questionid;

    public String getTxt() {
        return txt;
    }
    public void setTxt(String txt) {
        this.txt = txt;
    }
    public int getQuestionid() {
        return questionid;
    }
    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
}
