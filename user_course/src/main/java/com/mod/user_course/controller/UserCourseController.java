package com.mod.user_course.controller;

import com.mod.user_course.service.UserCourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    @PutMapping("/course/{title}")
    public ResponseEntity<?> addCourse(HttpServletRequest httpServletRequest, @PathVariable String title) {
        return userCourseService.addCourse(title);
    }

    @PostMapping("/user/{username}")
    public ResponseEntity<?> postUser(@PathVariable String username) {
        return userCourseService.putUser(username);
    }

    @DeleteMapping("/user/")
    public ResponseEntity<?> deleteUser() {
        return userCourseService.deleteUser();
    }

    @DeleteMapping("/course/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable String id) {
        return userCourseService.deleteCourse(id);
    }
    

}
