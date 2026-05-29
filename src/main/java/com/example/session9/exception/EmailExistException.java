package com.example.session9.exception;

public class EmailExistException extends RuntimeException {
    public EmailExistException(String message) {
        super(message);
    }
}
