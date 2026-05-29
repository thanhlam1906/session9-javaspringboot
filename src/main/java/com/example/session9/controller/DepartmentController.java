package com.example.session9.controller;

import com.example.session9.model.dto.request.DepartmentDTO;
import com.example.session9.model.dto.response.ApiDataResponse;
import com.example.session9.model.entity.Department;
import com.example.session9.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<ApiDataResponse<Department>> createDepartment(@Valid @RequestBody DepartmentDTO departmentDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiDataResponse.<Department>builder().success(true).message("sucess").data(departmentService.createDepartment(departmentDTO)).httpStatus(HttpStatus.CREATED).build());
    }
}
