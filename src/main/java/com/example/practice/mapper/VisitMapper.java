package com.example.practice.mapper;

import com.example.practice.dto.VisitDTO;
import com.example.practice.model.Visit;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VisitMapper {
    VisitDTO toVisitDTO(Visit visit);
}
