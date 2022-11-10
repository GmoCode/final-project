package com.finalproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.finalproject.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class RegistrationDTO {


    private Integer idRegistration;
    private LocalDateTime date;

    @JsonIncludeProperties(value = {"idStudent","nameStudent","lastNameStudent"})
    private StudentDTO student;

    private boolean enabled;
    @JsonManagedReference
    private List<RegistrationDetailDTO> details;

}
