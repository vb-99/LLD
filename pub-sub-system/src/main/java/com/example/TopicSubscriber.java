package com.example;

import java.util.concurrent.atomic.AtomicInteger;

public class TopicSubscriber implements Runnable {
    private Topic topic;
    private InSubscriber subscriber;
    private AtomicInteger offset;

    public TopicSubscriber(Topic topic, InSubscriber subscriber) {
        this.topic = topic;
        this.subscriber = subscriber;
        this.offset = new AtomicInteger(0);
    }
    public Topic getTopic() {
        return topic;
    }
    public InSubscriber getSubscriber() {
        return subscriber;
    }
    public AtomicInteger getOffset() {
        return offset;
    }
    public void setOffset(AtomicInteger offset) {
        this.offset = offset;
    }

    @Override
    public void run() {
        while(true){
            Message messageToProcess = null;
            synchronized(this){
                while(topic.getMessages().size() <= offset.get()){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                messageToProcess = topic.getMessages().get(offset.get());
                offset.incrementAndGet();
            }
            subscriber.consumeMessage(topic.getTopicId(),messageToProcess);
        }
    }


}
