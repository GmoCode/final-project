package com.finalproject.service.impl;

import com.finalproject.model.Student;
import com.finalproject.repo.IStudentRepo;
import com.finalproject.repo.IGenericRepo;
import com.finalproject.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Service
public class StudentServiceImpl extends CRUDImpl<Student, Integer> implements IStudentService {

    @Autowired
    private IStudentRepo repo;


    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }


    @Override
    public List<Student> getAgeSortedByDesc() {

         return repo.findAll().stream()
                 .sorted(Comparator.comparingDouble(Student::getAge).reversed())
                 .collect(Collectors.toList());
    }
}
