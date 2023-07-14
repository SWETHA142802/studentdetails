package com.studentDetails.studentdata.dto;
import java.util.List;

public class StudentDto {
    private Long id;
    private String firstname;
    private String lastname;
    private List<CourseDto> courses;

    public StudentDto() {
    }

    public StudentDto(Long id, String firstname, String lastname, List<CourseDto> courses) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<CourseDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDto> courses) {
        this.courses = courses;
    }
}
