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

public class StudentDTO {

    private Integer idStudent;

    @NotNull
    @NotEmpty
    @Size (min = 3, max = 100)
    private String nameStudent;

    @NotNull
    @NotEmpty
    @Size (min = 3, max = 100)
    private String lastNameStudent;

    @NotNull
    @NotEmpty
    @Size ( min = 8, max = 8)
    private String cardIdStudent;

    @Min(15)
    @Max(99)
    private Integer ageStudent;
}
