package com.smarthome.core;

public interface SmartComponent {
    String getName();
    boolean isOn();
    void turnOn();
    void turnOff();
}
