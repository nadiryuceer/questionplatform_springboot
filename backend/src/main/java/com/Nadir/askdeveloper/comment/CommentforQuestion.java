package com.Nadir.askdeveloper.comment;

import com.Nadir.askdeveloper.question.Question;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "CFQ")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CommentforQuestion extends Comment{
    @ManyToOne
    private Question question;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
