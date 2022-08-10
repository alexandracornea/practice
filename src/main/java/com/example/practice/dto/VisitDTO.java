package com.example.practice.dto;

import com.example.practice.model.Doctor;
import com.example.practice.model.Patient;
import com.example.practice.model.Visit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitDTO {
    private Patient patient;
    private Doctor doctor;
    private Date date;

    public VisitDTO(Visit visit) {
        this.patient = visit.getPatient();
        this.doctor = visit.getDoctor();
        this.date = visit.getDate();
    }
}
