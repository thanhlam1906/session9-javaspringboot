package com.example.session9.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "candidate")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@lombok.Getter
@Builder
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "cv_Url", nullable = false)
    private String cvUrl;
}
