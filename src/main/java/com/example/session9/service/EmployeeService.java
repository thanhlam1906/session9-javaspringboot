package com.example.session9.service;

import com.example.session9.exception.EmailExistException;
import com.example.session9.exception.ImageFileTooLargeException;
import com.example.session9.exception.InvalidImageFileException;
import com.example.session9.exception.ResourceNotFoundException;
import com.example.session9.model.dto.request.EmployeeCreateDTO;
import com.example.session9.model.entity.Department;
import com.example.session9.model.entity.Employee;
import com.example.session9.repository.IDepartmentRepository;
import com.example.session9.repository.IEmployeeReposity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final IEmployeeReposity employeeReposity;
    private final IDepartmentRepository departmentRepository;
    private final CloudinaryService cloudinaryService;
    public Employee createEmployee(EmployeeCreateDTO dto){
        Long id = dto.getDepartmentId();
        Department department = departmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Khong tim thay id  phong ban"));

        if(employeeReposity.findByEmail(dto.getEmail()) != null ){
            throw new EmailExistException("Email da bi trung !");
        }
        Employee employee = Employee.builder().fullName(dto.getFullName()).email(dto.getEmail()).phone(dto.getPhone()).salary(dto.getSalary()).department(department).build();
        return employeeReposity.save(employee);
    }

    public Employee updateEmployee(Long id, MultipartFile file){

         if(file.getSize() > 2*1024*1024){
             throw new ImageFileTooLargeException("file an qua lon");
         }
        String fileName = file.getOriginalFilename();
        if(fileName == null || !fileName.matches("(?i).+\\.(png|jpg|jpeg)$")){
            throw new InvalidImageFileException("Chi cap nhan file anh duoi png, jpg, jpeg");
        }
        String imageUrl = cloudinaryService.uploadFile(file);
        Employee employee= employeeReposity.findById(id).orElseThrow(()-> new ResourceNotFoundException("Khong tim thay nhan vien"));
        employee.setAvatarUrl(imageUrl);
        return employeeReposity.save(employee);
    }
}
