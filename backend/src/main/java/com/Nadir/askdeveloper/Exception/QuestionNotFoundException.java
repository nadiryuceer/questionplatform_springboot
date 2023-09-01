package com.Nadir.askdeveloper.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.NOT_FOUND,
        reason = "requested question does not exist"
)
public class QuestionNotFoundException extends RuntimeException{
    public QuestionNotFoundException(){super("");}
}
