package com.example.practice.service;

import com.example.practice.model.Specialty;
import com.example.practice.model.Visit;
import com.example.practice.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitService {
    private final VisitRepository visitRepository;

    public List<Visit> getAllVisitsByCnpAndSpeciality(String cnp, Specialty specialty) {
        return visitRepository.getAllByPatient_CnpAndDoctor_Specialty(cnp, specialty);
    }
}
