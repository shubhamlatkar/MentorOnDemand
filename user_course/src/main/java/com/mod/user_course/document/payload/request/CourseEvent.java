package com.mod.user_course.document.payload.request;

import com.mod.user_course.document.Topic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseEvent {
    private String eventType;
    private CourseRequest course;
    private List<Topic> topics;
    private String title;
}
