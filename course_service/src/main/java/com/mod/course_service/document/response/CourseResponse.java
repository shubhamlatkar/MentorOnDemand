package com.mod.course_service.document.response;

import com.mod.course_service.document.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {
    private String id;
    private String mentorId;
    private String title;
    private String description;
    private String duration;
    private String fee;
    private String lectures;
    private String levels;
    private String reviews;

    public CourseResponse build(Course course) {
        if (course.getId() != null) this.id = course.getId();
        if (course.getDescription() != null) this.description = course.getDescription();
        if (course.getMentorId() != null) this.mentorId = course.getMentorId();
        if (course.getTitle() != null) this.title = course.getTitle();
        if (course.getDuration() != null) this.duration = course.getDuration();
        if (course.getFee() != null) this.fee = course.getFee();
        if (course.getLectures() != null) this.lectures = course.getLectures();
        if (course.getLevels() != null) this.levels = course.getLevels();
        if (course.getReviews() != null) this.reviews = course.getReviews();
        return this;
    }
}
