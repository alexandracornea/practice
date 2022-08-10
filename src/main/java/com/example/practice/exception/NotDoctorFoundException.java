package com.example.practice.exception;

public class NotDoctorFoundException extends Exception {
    public NotDoctorFoundException() {
        super("Doctor not found.");
    }
}
