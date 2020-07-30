package com.mod.course_service.document.dto;

import com.mongodb.lang.NonNull;

import java.util.List;

public class CourseRequest {
    @NonNull
    private String mentorId;
    @NonNull
    private String title;
    private List<TopicRequest> topics;

    public CourseRequest() {
    }

    public CourseRequest(String mentorId, String title, List<TopicRequest> topics) {
        this.mentorId = mentorId;
        this.title = title;
        this.topics = topics;
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

    public List<TopicRequest> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicRequest> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "CourseRequest{" +
                "mentorId='" + mentorId + '\'' +
                ", title='" + title + '\'' +
                ", topics=" + topics +
                '}';
    }
}
