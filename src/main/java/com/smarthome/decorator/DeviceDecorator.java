package com.smarthome.decorator;

import com.smarthome.core.SmartComponent;

public abstract class DeviceDecorator implements SmartComponent {
    private final SmartComponent delegate;

    protected DeviceDecorator(SmartComponent delegate) {
        this.delegate = delegate;
    }

    protected SmartComponent delegate() {
        return delegate;
    }

    @Override
    public String getName() {
        return delegate.getName();
    }

    @Override
    public boolean isOn() {
        return delegate.isOn();
    }

    @Override
    public void turnOn() {
        delegate.turnOn();
    }

    @Override
    public void turnOff() {
        delegate.turnOff();
    }
}
