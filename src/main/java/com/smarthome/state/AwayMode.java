package com.smarthome.state;

import com.smarthome.composite.DeviceGroup;

public class AwayMode extends HomeState {
    public AwayMode(DeviceGroup allDevices) {
        super(allDevices);
    }

    @Override
    public String name() {
        return "AWAY";
    }

    @Override
    protected void applyInternal() {
        allDevices.turnOff();
    }
}
