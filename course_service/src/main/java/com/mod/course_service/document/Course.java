package com.mod.course_service.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Document
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

    public Course() {
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMentorId() {
        return mentorId;
    }

    public void setMentorId(String mentorId) {
        this.mentorId = mentorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getLectures() {
        return lectures;
    }

    public void setLectures(String lectures) {
        this.lectures = lectures;
    }

    public String getLevels() {
        return levels;
    }

    public void setLevels(String levels) {
        this.levels = levels;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public void addTopic(Topic topic) {
        if (topics == null)
            topics = new ArrayList<>();
        topics.add(topic);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", mentorId='" + mentorId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                ", fee='" + fee + '\'' +
                ", lectures='" + lectures + '\'' +
                ", levels='" + levels + '\'' +
                ", reviews='" + reviews + '\'' +
                ", topics=" + topics +
                '}';
    }
}
