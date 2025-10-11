package com.example;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class PubSubController {
    private final Map<String,Topic> topicMap;
    private final Map<String, List<TopicSubscriber>> topicSubscribers;

    private AtomicInteger topicIdGenerator;

    public PubSubController() {
        topicMap = new ConcurrentHashMap<>();
        topicSubscribers = new ConcurrentHashMap<>();
        topicIdGenerator = new AtomicInteger(0);
    }

    public Topic createTopic(String topicName){
        Topic topic = new Topic(topicIdGenerator.incrementAndGet()+"",topicName);
        topicMap.put(topic.getTopicId(),topic);
        topicSubscribers.put(topic.getTopicId(),new CopyOnWriteArrayList<>());
        System.out.println("Topic created with id "+topic.getTopicId());
        return topic;
    }

    public void publish(IPublisher publisher,String topicId, Message message) {
        Topic topic = topicMap.get(topicId);
        if(topic!=null){
            topic.addMessage(message);
            List<TopicSubscriber> subscribers = topicSubscribers.get(topicId);
           for(TopicSubscriber subscriber: subscribers){
               synchronized (subscriber){
                   subscriber.notify();
               }
           }
        }else{
            System.out.println("Topic not found");
        }
    }

    public void subscribe(String topicId, InSubscriber subscriber){
        Topic topic = topicMap.get(topicId);
        if(topic!=null){
            TopicSubscriber ts = new TopicSubscriber(topic,subscriber);
            topicSubscribers.get(topicId).add(ts);
            Thread newSubscriberThread = new Thread(ts);
            newSubscriberThread.start();
            System.out.println("Subscriber added to topic "+topicId);
        } else{
            System.out.println("Topic not found");
        }

    }



}
