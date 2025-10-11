package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Topic {
    private String topicId;
    private List<Message> messages;
    private String topicName;

    public Topic(String topicId, String topicName) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.messages = new ArrayList<>();
    }
    public String getTopicId() {
        return topicId;
    }
    public String getTopicName() {
        return topicName;
    }
    public List<Message> getMessages() {
        return Collections.unmodifiableList(messages);
    }
    public synchronized void addMessage(Message message) {
        messages.add(message);
    }

}
