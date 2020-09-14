package com.mod.user_course.controller;

import com.mod.user_course.service.UserCourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-course/")
public class UserCourseController {

    private final UserCourseService userCourseService;

    public UserCourseController(UserCourseService userCourseService) {
        this.userCourseService = userCourseService;
    }

    @GetMapping("/course/")
    public ResponseEntity<?> getCourses() {
        return userCourseService.getCourses();
    }

    @GetMapping("/course/{title}")
    public ResponseEntity<?> getByCourseTitle(@PathVariable String title) {
        return userCourseService.getCourse(title);
    }

    @PutMapping("/user/{title}")
    public ResponseEntity<?> addCourse(@PathVariable String title) {
        return userCourseService.addCourse(title);
    }

    @DeleteMapping("/user/{title}")
    public ResponseEntity<?> deleteCourse(@PathVariable String title) {
        return userCourseService.deleteCourse(title);
    }

}
