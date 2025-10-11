package com.example;

public class TopicPublisher {
    private String topicId;
    private IPublisher publisher;

    public TopicPublisher(String topicId, IPublisher publisher) {
        this.topicId = topicId;
        this.publisher = publisher;
    }
    public String getTopicId() {
        return topicId;
    }
    public IPublisher getPublisher() {
        return publisher;
    }

    public void publish(Message message, PubSubController pubSubController){
        pubSubController.publish(publisher,topicId,message);

    }
}
