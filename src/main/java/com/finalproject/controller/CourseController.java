package com.finalproject.controller;

import com.finalproject.dto.CourseDTO;
import com.finalproject.dto.StudentDTO;
import com.finalproject.exception.ModelNotFoundException;
import com.finalproject.model.Course;
import com.finalproject.model.Student;
import com.finalproject.service.ICourseService;
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
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private ICourseService service;

    @Autowired
    @Qualifier("courseMapper")
    private ModelMapper mapper;


    @GetMapping
    public ResponseEntity<List<CourseDTO>> readAll() throws Exception{
        List<CourseDTO> list = service.readAll().stream().map(cat ->mapper.map(cat, CourseDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Course obj = service.readById(id);
        if( obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: "+id);
        }
        return new ResponseEntity<>(mapper.map(obj,CourseDTO.class),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> create(@Valid @RequestBody CourseDTO dto) throws Exception{
        Course obj = service.create(mapper.map(dto,Course.class));
        return new ResponseEntity<>(mapper.map(obj,CourseDTO.class),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CourseDTO> update(@Valid @RequestBody CourseDTO dto) throws Exception{
        Course obj = service.readById(dto.getIdCourse());

        if(obj == null){
            throw  new ModelNotFoundException("ID NOT FOUND: "+dto.getIdCourse());
        }

        Course cat = service.update(mapper.map(dto, Course.class));
        return new ResponseEntity<>(mapper.map(cat, CourseDTO.class) ,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable("id") Integer id) throws Exception{

        Course obj = service.readById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: "+ id);
        }

        service.delete(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
