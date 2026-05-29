package com.example.session9.repository;

import com.example.session9.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeReposity extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);
}
