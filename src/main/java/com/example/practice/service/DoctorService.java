package com.example.practice.service;

import com.example.practice.exception.NotDoctorFoundException;
import com.example.practice.model.Doctor;
import com.example.practice.model.Patient;
import com.example.practice.model.Specialty;
import com.example.practice.repository.DoctorRepository;
import com.example.practice.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public List<Doctor> getAllBySpecialty(Specialty specialty) {
        return doctorRepository.getAllBySpecialty(specialty);
    }

    public void addPatient(Integer doctorId, Integer patientId) throws NotDoctorFoundException {
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);

        if (doctor.isEmpty()) {
            throw new NotDoctorFoundException();
        }
        Optional<Patient> patient = patientRepository.findById(patientId);
        patient.ifPresent(doctor.get()::addPatient);
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
