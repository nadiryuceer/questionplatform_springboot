package com.Nadir.cs393project.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.DiscriminatorColumn;
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
