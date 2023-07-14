package com.studentDetails.studentdata.service;

import com.studentDetails.studentdata.dto.CourseDto;
import com.studentDetails.studentdata.dto.StudentDto;
import com.studentDetails.studentdata.entity.Course;
import com.studentDetails.studentdata.entity.Student;
import com.studentDetails.studentdata.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImplementation implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<StudentDto> findAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private StudentDto convertToDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstname(student.getFirstname());
        studentDto.setLastname(student.getLastname());
        List<CourseDto> courseDtos = student.getCourses().stream()
                .map(course -> {
                    CourseDto courseDto = new CourseDto();
                    courseDto.setId(course.getId());
                    courseDto.setCourse_name(course.getCourse_name());
                    courseDto.setStaff_name(course.getStaff_name());
                    return courseDto;
                })
                .collect(Collectors.toList());
        studentDto.setCourses(courseDtos);
        return studentDto;
    }

    @Override
    public Optional<StudentDto> findById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(this::convertToDto);
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
       Student student = convertToEntity(studentDto);
        student = studentRepository.save(student);
        return convertToDto(student);
    }

    private Student convertToEntity( StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setFirstname(studentDto.getFirstname());
        student.setLastname(studentDto.getLastname());
        return student;
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto) {
        Student student = convertToEntity(studentDto);
        student = studentRepository.save(student);
        return convertToDto(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);

    }
}
