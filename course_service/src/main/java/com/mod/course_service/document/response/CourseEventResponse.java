package com.mod.course_service.document.response;

import com.mod.course_service.document.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseEventResponse {
    private String eventType;
    private Course course;
    private String title;
}
