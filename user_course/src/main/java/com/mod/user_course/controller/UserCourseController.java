package com.mod.user_course.controller;

import com.mod.user_course.document.Course;
import com.mod.user_course.service.UserCourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PutMapping("/course/{title}")
    public ResponseEntity<?> addCourse(@PathVariable String title) {
        return userCourseService.addCourse(title);
    }

    @PutMapping("/course/")
    public ResponseEntity<?> patchCourse(@RequestBody Course course) {
        return userCourseService.patchCourse(course);
    }

    @PostMapping("/user/{username}")
    public ResponseEntity<?> postUser(@PathVariable String username) {
        return userCourseService.putUser(username);
    }

    @DeleteMapping("/user/")
    public ResponseEntity<?> deleteUser() {
        return userCourseService.deleteUser();
    }

    @DeleteMapping("/user/{title}")
    public ResponseEntity<?> deleteCourse(@PathVariable String title) {
        return userCourseService.deleteCourse(title);
    }

    @DeleteMapping("/course/{title}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TRAINER')")
    public ResponseEntity<?> deleteCourseTrainer(@PathVariable String title) {
        return userCourseService.deleteCourseTrainer(title);
    }

}
