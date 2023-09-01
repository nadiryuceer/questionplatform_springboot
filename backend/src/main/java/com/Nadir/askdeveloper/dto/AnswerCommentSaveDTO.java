package com.Nadir.askdeveloper.dto;

public class AnswerCommentSaveDTO {
    private String text;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
