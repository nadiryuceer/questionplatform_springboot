package com.Nadir.askdeveloper.comment;

import com.Nadir.askdeveloper.answer.Answer;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DiscriminatorValue(value = "CFA")
public class CommentforAnswer extends Comment{
    @ManyToOne
    private Answer answer;

    public Answer getAnswer() {
        return answer;
    }
    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
