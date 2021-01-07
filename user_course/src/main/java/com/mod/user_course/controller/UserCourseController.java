package com.mod.user_course.controller;

import com.mod.user_course.service.UserCourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-course/")
public class UserCourseController {

    private final UserCourseService userCourseService;

    public UserCourseController(UserCourseService userCourseService) {
        this.userCourseService = userCourseService;
    }

    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
    @GetMapping("/course/")
    public ResponseEntity<?> getCourses() {
        return userCourseService.getCourses();
    }

    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
    @GetMapping("/course/{title}")
    public ResponseEntity<?> getByCourseTitle(@PathVariable String title) {
        return userCourseService.getCourse(title);
    }

    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
    @PutMapping("/user/{title}")
    public ResponseEntity<?> addCourse(@PathVariable String title) {
        return userCourseService.addCourse(title);
    }

    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
    @DeleteMapping("/user/{title}")
    public ResponseEntity<?> deleteCourse(@PathVariable String title) {
        return userCourseService.deleteCourse(title);
    }

}
