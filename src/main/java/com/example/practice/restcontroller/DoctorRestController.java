package com.example.practice.restcontroller;

import com.example.practice.dto.DoctorDTO;
import com.example.practice.exception.NotDoctorFoundException;
import com.example.practice.mapper.DoctorMapper;
import com.example.practice.model.Doctor;
import com.example.practice.model.Specialty;
import com.example.practice.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("doctors")
public class DoctorRestController {
    private final DoctorService doctorService;
    private DoctorMapper doctorMapper;

    @GetMapping("all")
    public List<DoctorDTO> getAllDoctors() {
        if (doctorService.getAllDoctors().isEmpty()) {
            return null;
        }
        return doctorService.getAllDoctors().stream()
                .map(doctorMapper::toDoctorDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("specialty/{specialty}")
    public List<DoctorDTO> getAllBySpecialty(@PathVariable Specialty specialty) {
        return doctorService.getAllBySpecialty(specialty).stream()
                .map(doctorMapper::toDoctorDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("add-patient/{doctor-id}/{patient-id}")
    public boolean addPatient(@PathVariable("doctor-id") Integer doctorId,
                              @PathVariable("patient-id") Integer patientId) {
        try {
            doctorService.addPatient(doctorId, patientId);
            return true;
        } catch (NotDoctorFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @PostMapping("add-doctor")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }
}
