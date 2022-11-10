package com.finalproject.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class RegistrationDetailDTO {

    @JsonBackReference
    private RegistrationDTO registration;

    @JsonIncludeProperties(value = {"idCourse","nameCourse","acronymCourse"})
    private CourseDTO course;
    private String classroom;

}
