package com.finalproject.service.impl;

import com.finalproject.model.Course;
import com.finalproject.model.Registration;
import com.finalproject.repo.ICourseRepo;
import com.finalproject.repo.IGenericRepo;
import com.finalproject.repo.IRegistrationRepo;
import com.finalproject.service.ICourseService;
import com.finalproject.service.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RegistrationServiceImpl extends CRUDImpl<Registration, Integer> implements IRegistrationService {

    @Autowired
    private IRegistrationRepo repo;


    @Override
    protected IGenericRepo<Registration, Integer> getRepo() {
        return repo;
    }


    @Override
    public Map<String, String> getListEnrolledCourseAndStudent() {
        return repo.findAll()
                .stream()
                .collect(Collectors.groupingBy(s -> s.get));
    }
}
