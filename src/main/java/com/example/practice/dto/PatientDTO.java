package com.example.practice.dto;

import com.example.practice.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private String cnp;
    private String doctorName;

    public PatientDTO(Patient patient) {
        this.cnp = patient.getCnp();
        this.doctorName = patient.getDoctor().getName();
    }
}
