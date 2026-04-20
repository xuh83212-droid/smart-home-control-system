package com.smarthome.observer;

public interface SensorSubject {
    void addObserver(SensorObserver observer);
    void removeObserver(SensorObserver observer);
    void notifyObservers();
}
