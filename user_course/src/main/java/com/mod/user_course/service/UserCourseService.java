package com.mod.user_course.service;

import com.mod.user_course.document.Course;
import com.mod.user_course.document.UserCourse;
import com.mod.user_course.repository.UserCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserCourseService {

    private final UserCourseRepository userCourseRepository;
    @Autowired
    private RestTemplate restTemplate;

    public UserCourseService(UserCourseRepository userCourseRepository) {
        this.userCourseRepository = userCourseRepository;
    }

    public ResponseEntity<?> deleteUser() {
        UserCourse user = userCourseRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
        if (user != null) {
            userCourseRepository.delete(user);
            return ResponseEntity.ok().body("deleted...");
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> deleteCourse(String title) {
        UserCourse user = userCourseRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
        if (user != null) {
            List<Course> courses =
                    user.getCourses();
            user.setCourses(courses.stream().filter(course -> !course.getTitle().equals(title)).collect(Collectors.toList()));
            userCourseRepository.save(user);
            return ResponseEntity.ok().body("deleted...");
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> putUser(String username) {
        return ResponseEntity.ok(userCourseRepository.save(new UserCourse(username)));
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

    public ResponseEntity<?> patchCourse(Course course) {
        List<UserCourse> courses = userCourseRepository.findByCourseTitle(course.getTitle()).orElse(null);
        if (courses == null)
            return ResponseEntity.notFound().build();
        courses.forEach(found -> {
            List<Course> foundCourses = found.getCourses();
            foundCourses.forEach(foundCourse -> {
                if (foundCourse.getTitle().equals(course.getTitle())) {
                    foundCourse.setDescription(course.getDescription());
                    foundCourse.setDuration(course.getDuration());
                    foundCourse.setFee(course.getFee());
                    foundCourse.setLectures(course.getLectures());
                    foundCourse.setMentorId(course.getMentorId());
                    foundCourse.setLevels(course.getLevels());
                    foundCourse.setReviews(course.getReviews());
                    foundCourse.setTopics(course.getTopics());
                }
            });
            found.setCourses(foundCourses);
        });
        return ResponseEntity.ok(userCourseRepository.saveAll(courses));
    }

    public ResponseEntity<?> deleteCourseTrainer(String title) {
        List<UserCourse> courses = userCourseRepository.findByCourseTitle(title).orElse(null);
        if (courses == null)
            return ResponseEntity.notFound().build();
        courses.forEach(found -> {
            List<Course> foundCourses = found.getCourses();
            foundCourses = foundCourses.stream().filter(foundCourse -> !foundCourse.getTitle().equals(title)).collect(Collectors.toList());
            found.setCourses(foundCourses);
        });
        return ResponseEntity.ok(userCourseRepository.saveAll(courses));
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


}
