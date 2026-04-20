package com.smarthome.state;

import com.smarthome.composite.DeviceGroup;
import com.smarthome.mode.ModeContext;

public abstract class HomeState implements HomeModeState {
    protected final DeviceGroup allDevices;

    protected HomeState(DeviceGroup allDevices) {
        this.allDevices = allDevices;
    }

    @Override
    public void apply(ModeContext context) {
        applyInternal();
        context.setCurrent(this);
    }

    protected abstract void applyInternal();
}
