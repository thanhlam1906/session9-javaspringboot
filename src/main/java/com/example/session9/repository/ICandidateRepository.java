package com.example.session9.repository;

import com.example.session9.model.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICandidateRepository extends JpaRepository<Candidate, Long> {
}
