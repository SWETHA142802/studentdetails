package com.studentDetails.studentdata.service;
import com.studentDetails.studentdata.dto.CourseDto;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<CourseDto> findAllCourse();
    Optional<CourseDto> findById(Long id);
    CourseDto createCourse(CourseDto courseDto);
    CourseDto updateCourse(CourseDto courseDto);
    void deleteCourse(Long id);
}
