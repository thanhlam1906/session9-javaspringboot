package com.example.session9.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "department")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@lombok.Getter
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false, length = 50)
    private String description;


}
