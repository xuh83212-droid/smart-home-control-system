package com.smarthome.observer;

public interface SensorObserver {
    void onSensorChanged(String sensorType, double value);
}
