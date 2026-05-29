package com.example.session9.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@lombok.Getter
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name="fullname", nullable=false, length=100)
    private String fullName;
    @Column(name= "email", nullable = false,unique = true)
    private String email;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "salary")
    private Long salary;
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
    @Column(name = "avatar_url")
    private String avatarUrl;

}
