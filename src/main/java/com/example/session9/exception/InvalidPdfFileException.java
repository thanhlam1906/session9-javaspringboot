package com.example.session9.exception;

public class InvalidPdfFileException extends RuntimeException {
    public InvalidPdfFileException(String message) {
        super(message);
    }
}
