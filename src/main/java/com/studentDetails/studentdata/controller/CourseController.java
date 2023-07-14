package com.studentDetails.studentdata.controller;

import com.studentDetails.studentdata.dto.CourseDto;
import com.studentDetails.studentdata.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping
    public List<CourseDto> findAllCourse(){
        return courseService.findAllCourse();
    }
    @GetMapping("/{id}")
    public Optional<CourseDto> findCourseById(@PathVariable("id") Long id){
        return courseService.findById(id);
    }
    @PostMapping
    public CourseDto createCourse(@RequestBody CourseDto courseDto){
        return courseService.createCourse(courseDto);
    }
    @PutMapping
    public CourseDto updateCourse(@RequestBody CourseDto courseDto){
        return courseService.updateCourse(courseDto);
    }
    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable("id") Long id){
        courseService.deleteCourse(id);
    }
}
