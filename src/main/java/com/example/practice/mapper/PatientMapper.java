package com.example.practice.mapper;

import com.example.practice.dto.PatientDTO;
import com.example.practice.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PatientMapper {
    PatientDTO toPatientDTO(Patient patient);
}
