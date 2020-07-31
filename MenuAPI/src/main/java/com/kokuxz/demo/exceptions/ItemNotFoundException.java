package com.kokuxz.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Item not found!")
public class ItemNotFoundException extends RuntimeException{

    //Constructor
    public ItemNotFoundException(){

    }

    public ItemNotFoundException(String message){
        super(message);
    }
}
