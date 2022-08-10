package com.example.practice.model;

import com.example.practice.observer.PatientObserver;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
// Observable
public class Patient {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String cnp;

    @OneToMany
    private List<Visit> visits = new ArrayList<>();

    @NotNull
    @ManyToOne
    private Doctor doctor;

    @Transient
    private PatientObserver patientObserver;

    public void attachObserver(PatientObserver patientObserver) {
        this.patientObserver = patientObserver;
    }

    public void notifyObserver() {
        this.patientObserver.update();
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
        this.notifyObserver();
    }
}
