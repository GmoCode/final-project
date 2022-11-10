package com.finalproject.controller;

import com.finalproject.dto.RegistrationDTO;
import com.finalproject.dto.StudentDTO;
import com.finalproject.exception.ModelNotFoundException;
import com.finalproject.model.Registration;
import com.finalproject.model.Student;
import com.finalproject.service.IRegistrationService;
import com.finalproject.service.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    @Autowired
    private IRegistrationService service;

    @Autowired
    @Qualifier("registrationMapper")
    private ModelMapper mapper;


    @GetMapping
    public ResponseEntity<List<RegistrationDTO>> readAll() throws Exception{
        List<RegistrationDTO> list = service.readAll().stream().map(cat ->mapper.map(cat, RegistrationDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Registration obj = service.readById(id);
        if( obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: "+id);
        }
        return new ResponseEntity<>(mapper.map(obj,RegistrationDTO.class),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RegistrationDTO> create(@Valid @RequestBody RegistrationDTO dto) throws Exception{
        Registration obj = service.create(mapper.map(dto,Registration.class));
        return new ResponseEntity<>(mapper.map(obj,RegistrationDTO.class),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<RegistrationDTO> update(@Valid @RequestBody RegistrationDTO dto) throws Exception{
        Registration obj = service.readById(dto.getIdRegistration());

        if(obj == null){
            throw  new ModelNotFoundException("ID NOT FOUND: "+dto.getIdRegistration());
        }

        Registration cat = service.update(mapper.map(dto, Registration.class));
        return new ResponseEntity<>(mapper.map(cat, RegistrationDTO.class) ,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable("id") Integer id) throws Exception{

        Registration obj = service.readById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: "+ id);
        }

        service.delete(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
