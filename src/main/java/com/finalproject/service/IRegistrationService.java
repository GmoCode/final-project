package com.finalproject.service;

import com.finalproject.model.Course;
import com.finalproject.model.Registration;

import java.util.Map;

public interface IRegistrationService extends ICRUD<Registration, Integer>{

    Map<String, String> getListEnrolledCourseAndStudent();

}
