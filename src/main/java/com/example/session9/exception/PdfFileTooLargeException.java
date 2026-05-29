package com.example.session9.exception;

public class PdfFileTooLargeException extends RuntimeException {
    public PdfFileTooLargeException(String message) {
        super(message);
    }
}
