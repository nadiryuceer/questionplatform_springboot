package com.Nadir.askdeveloper.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.OK,
        reason = "User already exists"
)
public class UserExistsException extends RuntimeException {
    public UserExistsException(){super("");}
}
