package com.Nadir.askdeveloper.dto;

public class AnswerSaveDTO {
    private String text;
    private String username;

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
}