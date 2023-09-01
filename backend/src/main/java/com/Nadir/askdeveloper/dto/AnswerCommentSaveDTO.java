package com.Nadir.askdeveloper.dto;

public class AnswerCommentSaveDTO {
    String txt;
    int userid;

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
}
