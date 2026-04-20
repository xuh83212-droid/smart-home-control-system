package com.smarthome.composite;

import com.smarthome.device.SmartDevice;

/**
 * 组合模式：叶子节点，包装单个设备。
 */
public class DeviceLeaf implements HomeComponent {
    private final SmartDevice device;

    public DeviceLeaf(SmartDevice device) {
        this.device = device;
    }

    @Override
    public String getName() {
        return device.getName();
    }

    @Override
    public void display() {
    }
}
