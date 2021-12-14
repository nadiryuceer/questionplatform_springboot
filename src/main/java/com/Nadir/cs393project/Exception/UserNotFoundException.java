package com.Nadir.cs393project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.NOT_FOUND,
        reason = "requested question does not exist"
)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(){super("");}
}
