package com.smarthome.decorator;

import com.smarthome.device.SmartDevice;

/**
 * 装饰器模式：呼吸灯效果装饰器。
 */
public class BreathingLightDecorator extends DeviceDecorator {
    public BreathingLightDecorator(SmartDevice delegate) {
        super(delegate);
    }

    @Override
    public void turnOn() {
        super.turnOn();
    }
}
