package com.smarthome.decorator;

import com.smarthome.device.SmartDevice;

/**
 * 装饰器模式：定时功能装饰器。
 */
public class TimerDeviceDecorator extends DeviceDecorator {
    public TimerDeviceDecorator(SmartDevice delegate) {
        super(delegate);
    }

    @Override
    public void turnOn() {
        super.turnOn();
    }
}
