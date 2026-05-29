package com.example.session9.service;

import com.example.session9.model.dto.request.DepartmentDTO;
import com.example.session9.model.entity.Department;
import com.example.session9.repository.IDepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final IDepartmentRepository departmentRepository;
    public Department createDepartment (DepartmentDTO departmentDTO){
        Department department = Department.builder().name(departmentDTO.getName()).description(departmentDTO.getDescription()).build();
        return departmentRepository.save(department);
    }
}
