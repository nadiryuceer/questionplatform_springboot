package com.Nadir.askdeveloper.comment.dto;

public class QuestionCommentSaveDTO {
    private String text;
    private String username;
    private int questionid;

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }
}
