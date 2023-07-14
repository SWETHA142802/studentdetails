package com.studentDetails.studentdata.service;

import com.studentDetails.studentdata.dto.StudentDto;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentDto> findAllStudent();
    Optional<StudentDto> findById(Long id);
    StudentDto createStudent(StudentDto studentDto);
    StudentDto updateStudent(StudentDto studentDto);
    void deleteStudent(Long id);

}
