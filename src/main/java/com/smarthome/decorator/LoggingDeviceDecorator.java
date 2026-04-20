package com.smarthome.decorator;

import com.smarthome.core.SmartComponent;

public class LoggingDeviceDecorator extends DeviceDecorator {
    public LoggingDeviceDecorator(SmartComponent delegate) {
        super(delegate);
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("[LOG] turnOn -> " + getName());
    }

    @Override
    public void turnOff() {
        super.turnOff();
        System.out.println("[LOG] turnOff -> " + getName());
    }
}
