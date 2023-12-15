package Exercises.exercise5.DesignPatternsDemo.src;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class Subject {
    private final List<Observer> observers = new ArrayList<>();
    private String message;

    void attach(Observer observer) {
        observers.add(observer);
    }

    void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    void setMessage(String message) {
        this.message = message;
        notifyAllObservers();
    }
}

class ConcreteObserver implements Observer {
    private final String name;

    ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

