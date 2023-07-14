package com.studentDetails.studentdata.controller;
import com.studentDetails.studentdata.dto.StudentDto;
import com.studentDetails.studentdata.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<StudentDto>findAllStudent(){
        return studentService.findAllStudent();
    }
    @GetMapping("/{id}")
    public Optional<StudentDto> findStudentById(@PathVariable("id") Long id){
        return studentService.findById(id);
    }
    @PostMapping
    public StudentDto createStudent(@RequestBody StudentDto studentDto){
        return studentService.createStudent(studentDto);
    }
    @PutMapping
    public StudentDto updateStudent(@RequestBody StudentDto studentDto){
        return studentService.updateStudent(studentDto);
    }
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
    }
}
