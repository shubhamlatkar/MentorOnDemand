package com.mod.user_service.document.dto;

import java.util.List;

public class CourseList {
    private List<Course> courses;

    public CourseList(List<Course> courses) {
        this.courses = courses;
    }

    public CourseList() {
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "CourseList{" +
                "courses=" + courses +
                '}';
    }
}
