package com.example.practice.mapper;

import com.example.practice.dto.DoctorDTO;
import com.example.practice.model.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DoctorMapper {
    DoctorDTO toDoctorDTO(Doctor doctor);
}
