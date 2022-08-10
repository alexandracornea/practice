package com.example.practice.exception;

public class NotSpecialtyFoundException extends Exception {
    public NotSpecialtyFoundException() {
        super("Specialty not found.");
    }
}
