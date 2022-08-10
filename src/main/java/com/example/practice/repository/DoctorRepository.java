package com.example.practice.repository;

import com.example.practice.model.Doctor;
import com.example.practice.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findAll();

    Doctor getById(Integer id);

    List<Doctor> getAllBySpecialty(Specialty specialty);
}
