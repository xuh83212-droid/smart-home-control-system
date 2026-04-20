package com.smarthome.device;

/**
 * 设备模块：所有智能设备的统一接口。
 */
public interface SmartDevice {
    void turnOn();

    void turnOff();

    String getName();
}
