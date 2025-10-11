package com.example;

public class SimpleSubscriber implements InSubscriber{
    private String subscriberId;

    public SimpleSubscriber(String subscriberId) {
        this.subscriberId = subscriberId;
    }
    public String getSubscriberId() {
        return subscriberId;
    }
    @Override
    public void consumeMessage(String topicId, Message message) {
        System.out.println("Received message: "+message.getMessage()+" from topic: "+topicId + " for subscriber: "+subscriberId);
    }
}
