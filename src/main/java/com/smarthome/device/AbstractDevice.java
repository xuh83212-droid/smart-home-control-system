package com.smarthome.device;

/**
 * 设备模块：智能设备抽象基类，封装公共属性。
 */
public abstract class AbstractDevice implements SmartDevice {
    protected final String name;

    protected AbstractDevice(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
