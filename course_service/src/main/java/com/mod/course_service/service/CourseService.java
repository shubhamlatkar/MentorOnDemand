package com.mod.course_service.service;

import com.mod.course_service.config.EventConfig;
import com.mod.course_service.document.Course;
import com.mod.course_service.document.response.CourseEventResponse;
import com.mod.course_service.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CourseService {

    public final CourseRepository courseRepository;
    private final EventConfig eventConfig;

    public CourseService(CourseRepository courseRepository, EventConfig eventConfig) {
        this.courseRepository = courseRepository;
        this.eventConfig = eventConfig;
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

    public ResponseEntity<?> delete(String title) {
        Course found = courseRepository.findByTitle(title).orElse(null);
        if (found != null) {
            courseRepository.delete(found);
            eventConfig.ModAuth().send(MessageBuilder.withPayload(new CourseEventResponse("DELETE", null, title)).build());
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

    public ResponseEntity<?> patch(Course course) {
        Course found = courseRepository.findByTitle(course.getTitle()).orElse(null);
        if (found != null) {
            course.setId(found.getId());
            eventConfig.ModAuth().send(MessageBuilder.withPayload(new CourseEventResponse("PATCH", course, course.getTitle())).build());
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