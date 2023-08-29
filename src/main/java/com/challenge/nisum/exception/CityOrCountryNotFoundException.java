package com.challenge.nisum.exception;

public class CityOrCountryNotFoundException extends RuntimeException{

    public CityOrCountryNotFoundException(String message){
        super(message);
    }
}
