package com.mod.course_service.service;

import com.mod.course_service.document.Course;
import com.mod.course_service.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CourseService {

    public final CourseRepository courseRepository;
    @Autowired
    private RestTemplate restTemplate;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public ResponseEntity<?> get(String filterBy, String page, String limit) {
        if (filterBy != null)
            return ResponseEntity.ok(courseRepository.findAllByTitleContains(filterBy));
        else if (page != null && limit != null) {
            Pageable pageRequest = PageRequest.of(Integer.parseInt(page), Integer.parseInt(limit));
            List<Course> courses = courseRepository.findAll(pageRequest).getContent();
            return ResponseEntity.ok(courses);
        } else
            return ResponseEntity.ok(courseRepository.findAll());
    }

    public ResponseEntity<?> delete(String title, String jwt) {
        Course found = courseRepository.findByTitle(title).orElse(null);
        if (found != null) {
            courseRepository.delete(found);
            //make a call tho course-user service
            HttpHeaders headers = new HttpHeaders();
            jwt = "Bearer " + jwt;
            headers.add("Authorization", jwt);
            HttpEntity<String> entity = new HttpEntity<>("delete", headers);
            ResponseEntity<String> result = restTemplate.exchange(
                    "http://USER-COURSE-SERVICE/user-course/course/",
                    HttpMethod.DELETE,
                    entity,
                    String.class
            );
            return ResponseEntity.ok("deleted...");
        } else
            return ResponseEntity.notFound().build();

    }

    public ResponseEntity<?> post(Course course) {
        Course found = courseRepository.findByTitle(course.getTitle()).orElse(null);
        if (found != null) {
            return ResponseEntity.badRequest().body("Already exist");
        }
        return ResponseEntity.ok(courseRepository.save(course));
    }

    public ResponseEntity<?> patch(Course course, String jwt) {
        Course found = courseRepository.findByTitle(course.getTitle()).orElse(null);
        if (found != null) {
            course.setId(found.getId());
            //make a call tho course-user service
            HttpHeaders headers = new HttpHeaders();
            jwt = "Bearer " + jwt;
            headers.add("Authorization", jwt);
            HttpEntity<Course> entity = new HttpEntity<>(course, headers);
            ResponseEntity<String> result = restTemplate.exchange(
                    "http://USER-COURSE-SERVICE/user-course/course/",
                    HttpMethod.PUT,
                    entity,
                    String.class
            );
            return ResponseEntity.ok(courseRepository.save(course));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> get(String title) {
        Course found = courseRepository.findByTitle(title).orElse(null);
        return found != null ? ResponseEntity.ok(found) : ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> getTopics(String title) {
        Course found = courseRepository.findByTitle(title).orElse(null);
        return found != null ? ResponseEntity.ok(found.getTopics()) : ResponseEntity.notFound().build();
    }

}