package com.mod.user_service.document.dto;

import java.util.List;

public class TopicList {
    private List<Topic> topics;

    public TopicList() {
    }

    public TopicList(List<Topic> topics) {
        this.topics = topics;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "TopicList{" +
                "topics=" + topics +
                '}';
    }
}
