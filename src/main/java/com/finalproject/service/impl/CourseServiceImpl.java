package com.finalproject.service.impl;

import com.finalproject.model.Course;
import com.finalproject.repo.ICourseRepo;
import com.finalproject.repo.IGenericRepo;
import com.finalproject.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl extends CRUDImpl<Course, Integer> implements ICourseService {

    @Autowired
    private ICourseRepo repo;


    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }



}
