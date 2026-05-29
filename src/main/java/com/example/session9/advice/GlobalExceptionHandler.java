package com.example.session9.advice;

import com.example.session9.exception.*;
import com.example.session9.model.dto.response.ApiDataResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiDataResponse> handleValidationException(MethodArgumentNotValidException ex){
        HashMap<String,String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(),error.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiDataResponse.builder().success(false).message("Du lieu khong hop le").data(errors).httpStatus(HttpStatus.BAD_REQUEST).build());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiDataResponse> handleResourceNotFoundException(ResourceNotFoundException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiDataResponse.builder().success(false).message("Khong tim thay du lieu").data(exception.getMessage()).httpStatus(HttpStatus.BAD_REQUEST).build());
    }

    @ExceptionHandler(EmailExistException.class)
    public ResponseEntity<ApiDataResponse> handleEmailExistException(EmailExistException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ApiDataResponse.builder().success(false).message("Du lieu bi trung").data(exception.getMessage()).httpStatus(HttpStatus.CONFLICT).build());
    }

    @ExceptionHandler(ImageFileTooLargeException.class)
    public ResponseEntity<ApiDataResponse> handleImageFileTooLargeException(ImageFileTooLargeException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiDataResponse.builder().success(false).message("Du lieu khong hop le").data(exception.getMessage()).httpStatus(HttpStatus.BAD_REQUEST).build());
    }

    @ExceptionHandler(InvalidImageFileException.class)
    public ResponseEntity<ApiDataResponse> handleInvalidImageFileException(InvalidImageFileException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiDataResponse.builder().success(false).message("Du lieu khong hop le").data(exception.getMessage()).httpStatus(HttpStatus.BAD_REQUEST).build());
    }

    @ExceptionHandler(PdfFileTooLargeException.class)
    public ResponseEntity<ApiDataResponse> handlePdfFileTooLargeException(PdfFileTooLargeException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiDataResponse.builder().success(false).message("Du lieu khong hop le").data(exception.getMessage()).httpStatus(HttpStatus.BAD_REQUEST).build());
    }

    @ExceptionHandler(FileEmptyException.class)
    public ResponseEntity<ApiDataResponse> handleFileEmptyException(FileEmptyException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiDataResponse.builder().success(false).message("Du lieu khong hop le").data(exception.getMessage()).httpStatus(HttpStatus.BAD_REQUEST).build());
    }

    @ExceptionHandler(InvalidPdfFileException.class)
    public ResponseEntity<ApiDataResponse> handleInvalidPdfFileException(InvalidPdfFileException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiDataResponse.builder().success(false).message("Du lieu khong hop le").data(exception.getMessage()).httpStatus(HttpStatus.BAD_REQUEST).build());
    }
}
