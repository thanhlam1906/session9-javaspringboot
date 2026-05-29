package com.example.session9.model.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@NotBlank
@AllArgsConstructor
@NoArgsConstructor
@lombok.Getter
@Setter
@Builder
public class ApiDataResponse <T>{
    private boolean success;
    private String message;
    private T data;
    private HttpStatus httpStatus;
}

