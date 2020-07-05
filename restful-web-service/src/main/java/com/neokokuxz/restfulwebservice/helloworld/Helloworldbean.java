package com.neokokuxz.restfulwebservice.helloworld;

public class Helloworldbean {

    private String message;

    public Helloworldbean(String input){
        this.message = input;
    }

    public void setMessage(String newInput){
        this.message = newInput;
    }

    public String getMessage(){
        return this.message;
    }

    public String toString(){
        return String.format("HelloWorldBean [message=%s]", message);
    }
}
