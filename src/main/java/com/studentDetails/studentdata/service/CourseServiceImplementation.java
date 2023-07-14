package com.studentDetails.studentdata.service;

import com.studentDetails.studentdata.dto.CourseDto;
import com.studentDetails.studentdata.dto.StudentDto;
import com.studentDetails.studentdata.entity.Course;
import com.studentDetails.studentdata.entity.Student;
import com.studentDetails.studentdata.repository.CourseRepository;
import com.studentDetails.studentdata.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CourseServiceImplementation implements CourseService{
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CourseServiceImplementation(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }


    @Override
    public List<CourseDto> findAllCourse() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private CourseDto convertToDto(Course courses) {
        CourseDto courseDto = new CourseDto();
        courseDto.setId(courses.getId());
        courseDto.setCourse_name(courses.getCourse_name());
        courseDto.setStaff_name(courses.getStaff_name());
        Student student= courses.getStudent();
        if (student != null) {
            StudentDto studentDto = new StudentDto();
            studentDto.setId(student.getId());
            studentDto.setFirstname(student.getFirstname());
            studentDto.setLastname(student.getLastname());

        }
        return courseDto;
    }

    @Override
    public Optional<CourseDto> findById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.map(this::convertToDto);
    }
    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        Course course = convertToEntity(courseDto);

        // Save the student if it's not already saved
        Student student = course.getStudent();
        if (student != null && student.getId() == null) {
            student = studentRepository.save(student);
            course.setStudent(student);
        }

        course = courseRepository.save(course);
        return convertToDto(course);
    }

    private Course convertToEntity(CourseDto courseDto) {
        Course course = new Course();
        course.setId(courseDto.getId());
        course.setCourse_name(courseDto.getCourse_name());
        course.setStaff_name(courseDto.getStaff_name());
        Student student = courseDto.getStudent(); // Get the student from the courseDto
        course.setStudent(student);
        return course;
    }

    @Override
    public CourseDto updateCourse(CourseDto courseDto) {
        Course course = convertToEntity(courseDto);
        course = courseRepository.save(course);
        return convertToDto(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
