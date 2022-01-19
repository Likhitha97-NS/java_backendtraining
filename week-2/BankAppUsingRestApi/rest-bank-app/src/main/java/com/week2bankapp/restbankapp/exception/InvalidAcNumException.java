package com.week2bankapp.restbankapp.exception;

public class InvalidAcNumException extends RuntimeException{
    public InvalidAcNumException(String message) {
        super(message);
    }
}
