package com.example;


public class SimplePublisher implements IPublisher{
    private final String publisherId;
    private final PubSubController pubSubController;

    public SimplePublisher(String publisherId, PubSubController pubSubController) {
        this.publisherId = publisherId;
        this.pubSubController = pubSubController;
    }
    public String getPublisherId() {
        return publisherId;
    }
    @Override
    public void publish(String topicId, Message message) {
        pubSubController.publish(this,topicId,message);
        System.out.println("Published message: "+message.getMessage()+" to topic: "+topicId);
    }
}
