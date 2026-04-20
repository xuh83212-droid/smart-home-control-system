package com.smarthome.observer;

import java.util.ArrayList;
import java.util.List;

public class TemperatureSensor implements SensorSubject {
    private final List<SensorObserver> observers = new ArrayList<>();
    private double temperature;

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public void addObserver(SensorObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(SensorObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (SensorObserver observer : observers) {
            observer.onSensorChanged("temperature", temperature);
        }
    }
}
