package com.mod.user_course.document.payload.request;

import com.mod.user_course.document.Topic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private String id;
    private String mentorId;
    private String title;
    private String description;
    private String duration;
    private String fee;
    private String lectures;
    private String levels;
    private String reviews;
}
