package com.example.practice.repository;

import com.example.practice.model.Doctor;
import com.example.practice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findAll();

    Patient getByCnp(String cnp);

    List<Patient> getAllByDoctor(Doctor doctor);
}
