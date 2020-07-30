package com.mod.user_course.document;

import java.util.ArrayList;
import java.util.List;

public class Course {

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

    public Course(String id, String mentorId, String title) {
        this.id = id;
        this.mentorId = mentorId;
        this.title = title;
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
