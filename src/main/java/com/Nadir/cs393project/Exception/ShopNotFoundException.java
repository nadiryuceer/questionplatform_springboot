package com.Nadir.cs393project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.OK,
        reason = "Requested shop does not exist"
)
public class ShopNotFoundException extends RuntimeException{
    public ShopNotFoundException(String s){
        super(s);
    }
}
