package com.Nadir.askdeveloper.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        reason = "requested answer does not exist"
)
public class AnswerNotFoundException extends RuntimeException {
    public AnswerNotFoundException(){super("");}
}
