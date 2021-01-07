package com.mod.course_service.controller;

import com.mod.course_service.document.Course;
import com.mod.course_service.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    public ResponseEntity<?> filterCourse(
            @RequestParam(required = false) String filterBy,
            @RequestParam(required = false) String page,
            @RequestParam(required = false) String limit
    ) {
        return courseService.get(filterBy, page, limit);
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    @PostMapping("/")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TRAINER')")
    public ResponseEntity<?> postCourse(@RequestBody @Valid Course course) {
        return courseService.post(course);
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    @DeleteMapping("/{title}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TRAINER')")
    public ResponseEntity<?> deleteCourse(@PathVariable String title) {
        return courseService.delete(title);
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    @PatchMapping("/")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TRAINER')")
    public ResponseEntity<?> patchCourse(@RequestBody @Valid Course course) {
        return courseService.patch(course);
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> getCourse(@PathVariable String title) {
        return courseService.get(title);
    }

    @GetMapping("/topic/{title}")
    public ResponseEntity<?> getTopics(@PathVariable String title) {
        return courseService.getTopics(title);
    }

}
