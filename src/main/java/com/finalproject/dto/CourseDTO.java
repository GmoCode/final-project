package com.finalproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CourseDTO {

    private Integer idCourse;

    @NotNull
    @NotEmpty
    @Size (min = 3, max = 100)
    private String nameCourse;

    @NotNull
    @NotEmpty
    @Size (min = 3, max = 15)
    private String acronymCourse;

    @NotNull
    private boolean enabled;
}
