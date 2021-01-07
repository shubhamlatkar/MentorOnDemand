package com.mod.user_course.service;

import com.mod.user_course.document.Course;
import com.mod.user_course.document.Topic;
import com.mod.user_course.document.payload.request.CourseEvent;
import com.mod.user_course.document.payload.request.CourseRequest;
import com.mod.user_course.repository.UserCourseRepository;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final UserCourseRepository userCourseRepository;

    public CourseService(UserCourseRepository userCourseRepository) {
        this.userCourseRepository = userCourseRepository;
    }

    @StreamListener(target = "ModCourse")
    public void authConsumer(CourseEvent event) {
        switch (event.getEventType()) {
            case "PATCH":
                patch(event.getCourse(), event.getTopics());
                break;
            case "DELETE":
                delete(event.getTitle());
                break;
            default:
                break;
        }
    }

    private void patch(CourseRequest course, List<Topic> topics) {
        userCourseRepository.findByCourseTitle(course.getTitle()).ifPresent(userCourses -> {
            userCourseRepository.saveAll(userCourses.stream().peek(userCourse -> {
                Course found = userCourse.removeCourseByTitle(course.getTitle());
                if (topics != null) found.setTopics(topics);
                if (course.getReviews() != null) found.setReviews(course.getReviews());
                if (course.getLevels() != null) found.setLevels(course.getLevels());
                if (course.getMentorId() != null) found.setMentorId(course.getMentorId());
                if (course.getFee() != null) found.setFee(course.getFee());
                if (course.getDuration() != null) found.setDuration(course.getDuration());
                if (course.getDescription() != null) found.setDescription(course.getDescription());
                if (course.getLectures() != null) found.setLectures(course.getLectures());
                userCourse.addCourse(found);
            }).collect(Collectors.toList()));
        });
    }

    private void delete(String title) {
        userCourseRepository.findByCourseTitle(title).ifPresent(userCourses -> {
            userCourseRepository.saveAll(userCourses.stream().peek(userCourse -> {
                Course found = userCourse.removeCourseByTitle(title);
            }).collect(Collectors.toList()));
        });
    }
}