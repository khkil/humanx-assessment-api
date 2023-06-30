package com.octagnosis.api.inspection.service;

import com.octagnosis.api.inspection.domain.Inspection;
import com.octagnosis.api.inspection.dto.InspectionDto;
import com.octagnosis.api.inspection.repository.InspectionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InspectionService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    InspectionRepository inspectionRepository;

    public List<InspectionDto.Response> getInspectionList() {
        List<Inspection> inspectionList = inspectionRepository.findAll();
        return inspectionList.stream().map((element) -> modelMapper.map(element, InspectionDto.Response.class)).collect(Collectors.toList());
    }

    public void saveInspection(InspectionDto.Request inspectionDto) {
        Inspection inspection = modelMapper.map(inspectionDto, Inspection.class);
        inspectionRepository.save(inspection);
    }
}
