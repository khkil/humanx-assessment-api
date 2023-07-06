package com.octagnosis.api.test.service;

import com.octagnosis.api.test.domain.Test;
import com.octagnosis.api.test.dto.TestDto;
import com.octagnosis.api.test.repository.TestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    TestRepository testRepository;

    public List<TestDto.Response> getTestList() {
        List<Test> testList = testRepository.findAll();
        return testList.stream().map((element) -> modelMapper.map(element, TestDto.Response.class)).collect(Collectors.toList());
    }

    public void createTest(TestDto.Request testDto) {
        Test test = modelMapper.map(testDto, Test.class);
        testRepository.save(test);
    }
}
