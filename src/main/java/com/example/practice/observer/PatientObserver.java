package com.example.practice.observer;

import com.example.practice.model.Patient;

// Observer
public class PatientObserver {
    Patient patient;

    public PatientObserver(Patient patient) {
        this.patient = patient;
        this.patient.attachObserver(this);
    }

    public void update() {
        System.out.println("You have a new patient.");
    }
}
