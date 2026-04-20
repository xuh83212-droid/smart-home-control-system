package com.smarthome.state;

import com.smarthome.composite.DeviceGroup;

public class HomeMode extends HomeState {
    public HomeMode(DeviceGroup allDevices) {
        super(allDevices);
    }

    @Override
    public String name() {
        return "HOME";
    }

    @Override
    protected void applyInternal() {
        allDevices.turnOn();
    }
}
