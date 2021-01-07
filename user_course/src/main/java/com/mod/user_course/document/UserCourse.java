package com.mod.user_course.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class    UserCourse {

    @Id
    private String id;
    private String username;
    private List<Course> courses;

    public UserCourse() {
    }

    public UserCourse(String username, List<Course> courses) {
        this.username = username;
        this.courses = courses;
    }

    public UserCourse(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;

    }

    @Override
    public String toString() {
        return "UserCourse{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", courses=" + courses +
                '}';
    }

    public void addCourse(Course course) {
        if (courses == null)
            courses = new ArrayList<>();
        courses.add(course);
    }

    public Course removeCourseByTitle(String title) {
        if (courses != null) {
            Course found = courses.stream().filter(course -> course.getTitle().equals(title)).findFirst().orElse(null);
            courses.remove(found);
            return found;
        } else
            return null;
    }
}
