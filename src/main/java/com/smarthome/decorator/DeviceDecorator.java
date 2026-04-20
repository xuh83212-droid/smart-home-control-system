package com.smarthome.decorator;

import com.smarthome.device.SmartDevice;

/**
 * 装饰器模式：设备装饰器基类。
 */
public abstract class DeviceDecorator implements SmartDevice {
    protected final SmartDevice delegate;

    protected DeviceDecorator(SmartDevice delegate) {
        this.delegate = delegate;
    }

    @Override
    public void turnOn() {
        delegate.turnOn();
    }

    @Override
    public void turnOff() {
        delegate.turnOff();
    }

    @Override
    public String getName() {
        return delegate.getName();
    }
}
