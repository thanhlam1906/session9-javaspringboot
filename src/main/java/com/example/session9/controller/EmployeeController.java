package com.example.session9.controller;

import com.example.session9.model.dto.request.EmployeeCreateDTO;
import com.example.session9.model.dto.response.ApiDataResponse;
import com.example.session9.model.entity.Employee;
import com.example.session9.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<ApiDataResponse<Employee>> createEmployee(@Valid @RequestBody EmployeeCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiDataResponse.<Employee>builder().success(true).message("success")
                        .data(employeeService.createEmployee(dto)).httpStatus(HttpStatus.CREATED).build());

    }

    @PutMapping("/{id}/avatar")
    public ResponseEntity<ApiDataResponse<Employee>> updateEmployee(@PathVariable Long id,
            @RequestParam("file") MultipartFile file) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiDataResponse.<Employee>builder().success(true).message("success")
                        .data(employeeService.updateEmployee(id, file)).httpStatus(HttpStatus.OK).build());
    }
}
