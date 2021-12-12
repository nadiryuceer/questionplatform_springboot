package com.Nadir.cs393project.dto;

public class AnswerCommentSaveDTO {
    String txt;
    int userid;
    int answerid;

    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public String getTxt() {
        return txt;
    }
    public void setTxt(String txt) {
        this.txt = txt;
    }
    public int getAnswerid() {
        return answerid;
    }
    public void setAnswerid(int answerid) {
        this.answerid = answerid;
    }
}
