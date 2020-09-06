package com.mod.course_service.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    private String id;
    @NotNull
    private String mentorId;
    @Indexed(unique = true)
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private String duration;
    @NotNull
    private String fee;
    @NotNull
    private String lectures;
    @NotNull
    private String levels;
    @NotNull
    private String reviews;

    private List<Topic> topics;

    public Course(String mentorId, String title, String description, String duration, String fee, String lectures, String levels, String reviews) {
        this.mentorId = mentorId;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.fee = fee;
        this.lectures = lectures;
        this.levels = levels;
        this.reviews = reviews;
    }

    public Course(String mentorId, String title, String description, String duration, String fee, String lectures, String levels, String reviews, List<Topic> topics) {
        this.mentorId = mentorId;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.fee = fee;
        this.lectures = lectures;
        this.levels = levels;
        this.reviews = reviews;
        this.topics = topics;
    }

    public void addTopic(Topic topic) {
        if (topics == null)
            topics = new ArrayList<>();
        topics.add(topic);
    }
}
