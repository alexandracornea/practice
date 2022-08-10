package com.example.practice.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String name;

    @OneToMany
    private List<Patient> patients = new ArrayList<>();
    private Specialty specialty;

    public void addPatient(Patient patient) {
        patients.add(patient);
    }
}
