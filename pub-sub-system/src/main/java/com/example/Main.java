package com.example;

import java.util.concurrent.Flow;

public class Main {
    public static void main(String[] args) {
        PubSubController pubSubController = new PubSubController();
        Topic t1 = pubSubController.createTopic("Topic1");
        Topic t2 = pubSubController.createTopic("Topic2");

        SimplePublisher p1 = new SimplePublisher("Publisher1", pubSubController);
        SimplePublisher p2 = new SimplePublisher("Publisher2", pubSubController);

        SimpleSubscriber s1 = new SimpleSubscriber("Subscriber1");
        SimpleSubscriber s2 = new SimpleSubscriber("Subscriber2");
        SimpleSubscriber s3 = new SimpleSubscriber("Subscriber3");

        pubSubController.subscribe(t1.getTopicId(),s1);
        pubSubController.subscribe(t2.getTopicId(),s1);
        pubSubController.subscribe(t1.getTopicId(),s2);
        pubSubController.subscribe(t2.getTopicId(),s3);

        p1.publish(t1.getTopicId(),new Message("Message m1"));
        p1.publish(t2.getTopicId(),new Message("Message m2"));
        p2.publish(t2.getTopicId(),new Message("Message m3"));



    }
}