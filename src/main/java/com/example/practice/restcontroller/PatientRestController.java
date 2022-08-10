package com.example.practice.restcontroller;

import com.example.practice.dto.PatientDTO;
import com.example.practice.mapper.PatientMapper;
import com.example.practice.model.Doctor;
import com.example.practice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("patients")
public class PatientRestController {
    private final PatientService patientService;
    private PatientMapper patientMapper;

    @GetMapping("all")
    public List<PatientDTO> getAllPatients() {
        if (patientService.getAllPatients().isEmpty()) {
            return null;
        }
        return patientService.getAllPatients().stream()
                .map(patientMapper::toPatientDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("cnp/{cnp}")
    public PatientDTO getPatientByCnp(@PathVariable String cnp) {
        return patientMapper.toPatientDTO(patientService.getPatientByCnp(cnp));
    }

    @GetMapping("doctor/{doctor}")
    public List<PatientDTO> getAllByDoctor(@PathVariable Doctor doctor) {
        return patientService.getAllByDoctor(doctor).stream()
                .map(patientMapper::toPatientDTO)
                .collect(Collectors.toList());
    }
}
