package com.mod.user_course.document;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Topic {
    private String name;
    @JsonFormat
    private Boolean completed;

    public Topic() {
    }

    public Topic(String name, Boolean completed) {
        this.name = name;
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                ", completed=" + completed +
                '}';
    }
}
