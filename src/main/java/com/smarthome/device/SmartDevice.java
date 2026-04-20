package com.smarthome.device;

import com.smarthome.core.SmartComponent;

public class SmartDevice implements SmartComponent {
    private final String name;
    private boolean on;

    public SmartDevice(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isOn() {
        return on;
    }

    @Override
    public void turnOn() {
        on = true;
    }

    @Override
    public void turnOff() {
        on = false;
    }

    @Override
    public String toString() {
        return "SmartDevice{" + "name='" + name + '\'' + ", on=" + on + '}';
    }
}
