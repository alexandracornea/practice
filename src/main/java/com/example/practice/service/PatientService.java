package com.example.practice.service;

import com.example.practice.model.Doctor;
import com.example.practice.model.Patient;
import com.example.practice.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientByCnp(String cnp) {
        return patientRepository.getByCnp(cnp);
    }

    public List<Patient> getAllByDoctor(Doctor doctor) {
        return patientRepository.getAllByDoctor(doctor);
    }
}
