package com.example.session9.repository;

import com.example.session9.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department, Long > {

}
