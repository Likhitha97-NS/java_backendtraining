package com.wee2.casestudy.exception;

public class InvalidAmountException extends RuntimeException
{
    public InvalidAmountException(String message) {
        super(message);
    }
}
