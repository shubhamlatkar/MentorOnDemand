package com.mod.user_course.service;

import com.mod.user_course.document.Course;
import com.mod.user_course.document.UserCourse;
import com.mod.user_course.repository.UserCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class UserCourseService {

    private final UserCourseRepository userCourseRepository;
    @Autowired
    private RestTemplate restTemplate;

    public UserCourseService(UserCourseRepository userCourseRepository) {
        this.userCourseRepository = userCourseRepository;
    }

    public void deleteUser(String username) {
        userCourseRepository.findByUsername(username).ifPresent(userCourseRepository::delete);
    }

    public void putUser(String id, String username) {
        userCourseRepository.save(new UserCourse(id, username));
    }

    public ResponseEntity<?> addCourse(String title) {
        ResponseEntity<Course> courseResponse = restTemplate.getForEntity("http://COURSE-SERVICE/course/" + title, Course.class);
        Course course = null;
        if (courseResponse.getBody() != null)
            course = courseResponse.getBody();
        UserCourse user = userCourseRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
        if (user != null && course != null) {
            user.addCourse(course);
            return ResponseEntity.ok(userCourseRepository.save(user));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> getCourses() {
        UserCourse user = userCourseRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
        if (user != null)
            return ResponseEntity.ok(user.getCourses());
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> getCourse(String title) {
        UserCourse user = userCourseRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
        if (user != null) {
            Optional<Course> found = user.getCourses().stream().filter(course -> course.getTitle().equals(title)).findAny();
            if (found.isPresent())
                return ResponseEntity.ok(found);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> deleteCourse(String title) {
        UserCourse userCourse = userCourseRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
        if (userCourse != null && userCourse.removeCourseByTitle(title) != null)
            return ResponseEntity.status(HttpStatus.OK).body("Deleted.....");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NotFound....");
    }
}
