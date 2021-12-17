package com.Nadir.cs393project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.NOT_FOUND,
        reason = "Requested comment does not exist"
)
public class CommentNotFoundException extends RuntimeException{
    public CommentNotFoundException(){
        super("");
    }
}
