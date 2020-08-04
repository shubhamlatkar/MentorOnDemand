package com.mod.course_service.document.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.lang.NonNull;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

public class TopicRequest {
//    @MongoId(FieldType.OBJECT_ID)
//    private String id;

    @NonNull
    private String name;
    @JsonProperty
    private Boolean isCompleted;

    public TopicRequest() {
    }

    public TopicRequest(String name, Boolean isCompleted) {
        this.name = name;
        this.isCompleted = isCompleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "TopicRequest{" +
                "name='" + name + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
