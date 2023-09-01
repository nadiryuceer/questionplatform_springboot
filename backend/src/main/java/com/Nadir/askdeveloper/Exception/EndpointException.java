package com.Nadir.askdeveloper.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class EndpointException {
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND,reason = "this endpoint is not configured in backend")
    @ResponseBody
    public RuntimeException requestHandlingNoHandlerFound() {
        return new RuntimeException("");
    }
}
