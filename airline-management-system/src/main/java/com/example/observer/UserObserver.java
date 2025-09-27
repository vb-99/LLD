package com.example.observer;

public class UserObserver implements ObserverInterface{

    @Override
    public void notifyObservers(String message) {
        System.out.println("Message sent" + message);
    }
}
