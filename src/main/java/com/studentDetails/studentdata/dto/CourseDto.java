package com.studentDetails.studentdata.dto;

import com.studentDetails.studentdata.entity.Student;

public class CourseDto {
    private Long id;
    private String course_name;
    private String staff_name;
    private Student student;


    public CourseDto() {
    }

    public CourseDto(Long id, String course_name, String staff_name, Student student) {
        this.id = id;
        this.course_name = course_name;
        this.staff_name = staff_name;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
