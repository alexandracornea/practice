package com.example.practice.restcontroller;

import com.example.practice.dto.VisitDTO;
import com.example.practice.mapper.VisitMapper;
import com.example.practice.model.Specialty;
import com.example.practice.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("visits")
public class VisitRestController {
    private final VisitService visitService;
    private VisitMapper visitMapper;

    @GetMapping("by-cnp-and-speciality/{cnp}/{specialty}")
    public List<VisitDTO> getAllVisitsByCnpAndSpeciality(@PathVariable String cnp,
                                                         @PathVariable Specialty specialty) {
        return visitService.getAllVisitsByCnpAndSpeciality(cnp, specialty).stream()
                .map(visitMapper::toVisitDTO)
                .collect(Collectors.toList());
    }
}
