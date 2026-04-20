package com.smarthome.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式：温度传感器主题。
 */
public class TemperatureSensor implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private double temperature;

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}
