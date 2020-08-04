package com.mod.course_service.controller;

import com.mod.course_service.document.Course;
import com.mod.course_service.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Objects;
import java.util.Optional;

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

    @PostMapping("/")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TRAINER')")
    public ResponseEntity<?> postCourse(@RequestBody @Valid Course course) {
        return courseService.post(course);
    }

    @DeleteMapping("/")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TRAINER')")
    public ResponseEntity<?> deleteCourse(HttpServletRequest httpServletRequest, @RequestBody String title) {
        final String authorization = httpServletRequest.getHeader("Authorization");
        String jwt = null;
        if (authorization != null && authorization.startsWith("Bearer ")) {
            jwt = authorization.substring(7);
            return courseService.delete(title, jwt);
        }
        return ResponseEntity.badRequest().body("Unauthorized");
    }


    @PatchMapping("/")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TRAINER')")
    public ResponseEntity<?> patchCourse(HttpServletRequest httpServletRequest, @RequestBody @Valid Course course) {
        final String authorization = httpServletRequest.getHeader("Authorization");
        String jwt = null;
        if (authorization != null && authorization.startsWith("Bearer ")) {
            jwt = authorization.substring(7);
            return courseService.patch(course, jwt);
        }
        return ResponseEntity.badRequest().body("Unauthorized");

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
