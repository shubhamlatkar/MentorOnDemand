package com.mod.user_course.controller;

import com.mod.user_course.document.Course;
import com.mod.user_course.document.Topic;
import com.mod.user_course.document.UserCourse;
import com.mod.user_course.repository.UserCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user-course/")
public class UserCourseController {

    private final UserCourseRepository userCourseRepository;

    @Autowired
    private RestTemplate restTemplate;

    public UserCourseController(UserCourseRepository userListRepository) {
        this.userCourseRepository = userListRepository;
    }

    @GetMapping("/")
    public ResponseEntity<?> defaultGet() {
        Topic topic = new Topic("Angular", false);
        Course courseList = new Course("13qwe", "MeanFS", Arrays.asList(topic));
        UserCourse user = new UserCourse("shu", "shu@shu.com");
        user.addCourse(courseList);
        userCourseRepository.save(user);
        return ResponseEntity.ok(userCourseRepository.findAll());
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<?> getByEmail(@PathVariable String username) {
        return ResponseEntity.ok(userCourseRepository.findByName(username));
    }

    @GetMapping("/course/{title}")
    public ResponseEntity<?> getByCourseTitle(@PathVariable String title) {
        return ResponseEntity.ok(userCourseRepository.findByCourseTitle(title));
    }

    @PutMapping("/course/{id}")
    public ResponseEntity<?> putCourse(@PathVariable String id) {

        Course course = restTemplate.getForObject(
                "http://COURSE-SERVICE/course/" + id, Course.class);
        ResponseEntity<Topic[]> response = restTemplate.getForEntity(
                "http://COURSE-SERVICE/course/topic/" + id, Topic[].class);

        List<Topic> topics = null;
        if (response.getBody() != null)
            topics = Arrays.asList(response.getBody());

        if (course != null && topics != null)
            course.setTopics(topics);

        UserCourse user = userCourseRepository.findByName("shu").orElse(null);
        if (user != null) {
            user.addCourse(course);
            userCourseRepository.save(user);
        }

        return ResponseEntity.ok(userCourseRepository.findAll());
    }

    @PostMapping("/user/")
    public ResponseEntity<?> postUser(@RequestBody UserCourse user) {
        System.out.println(user);
        userCourseRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("success");
    }
}
