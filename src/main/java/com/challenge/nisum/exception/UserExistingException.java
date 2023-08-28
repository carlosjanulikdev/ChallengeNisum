package com.challenge.nisum.exception;

public class UserExistingException extends RuntimeException{

    public UserExistingException(String message){
        super(message);
    }
}
