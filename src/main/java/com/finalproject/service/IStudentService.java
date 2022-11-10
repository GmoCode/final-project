package com.finalproject.service;

import com.finalproject.dto.StudentDTO;
import com.finalproject.model.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService extends ICRUD<Student, Integer>{


    List<Student> getAgeSortedByDesc();
}
