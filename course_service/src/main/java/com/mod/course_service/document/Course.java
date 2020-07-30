package com.mod.course_service.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Course {
    @Id
    private String id;
    private String mentorId;
    private String title;
    private List<Topic> topics;

    public Course() {
    }

    public Course(String mentorId, String title) {
        this.mentorId = mentorId;
        this.title = title;
    }

    public Course(String mentorId, String title, List<Topic> topics) {
        this.mentorId = mentorId;
        this.title = title;
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

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", mentorId='" + mentorId + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public void addTopic(Topic topic) {
        if(topics == null)
            topics = new ArrayList<>();
        topics.add(topic);
    }
}
