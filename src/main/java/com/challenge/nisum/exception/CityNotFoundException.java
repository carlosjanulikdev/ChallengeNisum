package com.challenge.nisum.exception;

public class CityNotFoundException extends RuntimeException{

    public CityNotFoundException(String message){
        super(message);
    }
}
