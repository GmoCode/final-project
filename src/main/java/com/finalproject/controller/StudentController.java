package com.finalproject.controller;

import com.finalproject.dto.StudentDTO;
import com.finalproject.exception.ModelNotFoundException;
import com.finalproject.model.Student;
import com.finalproject.service.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService service;

    @Autowired
    @Qualifier("studentMapper")
    private ModelMapper mapper;


    @GetMapping
    public ResponseEntity<List<StudentDTO>> readAll() throws Exception{
        List<StudentDTO> list = service.readAll().stream().map(cat ->mapper.map(cat, StudentDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Student obj = service.readById(id);
        if( obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: "+id);
        }
        return new ResponseEntity<>(mapper.map(obj,StudentDTO.class),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody StudentDTO dto) throws Exception{
        Student obj = service.create(mapper.map(dto,Student.class));
        return new ResponseEntity<>(mapper.map(obj,StudentDTO.class),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<StudentDTO> update(@Valid @RequestBody StudentDTO dto) throws Exception{
        Student obj = service.readById(dto.getIdStudent());

        if(obj == null){
            throw  new ModelNotFoundException("ID NOT FOUND: "+dto.getIdStudent());
        }

        Student cat = service.update(mapper.map(dto, Student.class));
        return new ResponseEntity<>(mapper.map(cat, StudentDTO.class) ,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable("id") Integer id) throws Exception{

        Student obj = service.readById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: "+ id);
        }

        service.delete(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/age-desc")
    public ResponseEntity<List<StudentDTO>> getAgeSortedByDesc() throws Exception {
        List<StudentDTO> list =  service.getAgeSortedByDesc().stream().map(cat ->mapper.map(cat, StudentDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
