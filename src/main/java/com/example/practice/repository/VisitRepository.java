package com.example.practice.repository;

import com.example.practice.model.Specialty;
import com.example.practice.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
    List<Visit> findAll();

    List<Visit> getAllByPatient_CnpAndDoctor_Specialty(String cnp, Specialty specialty);
}
