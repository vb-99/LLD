package com.example;

public interface InSubscriber {
    void consumeMessage(String topicId,Message message);
}
