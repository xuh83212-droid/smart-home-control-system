package com.smarthome.factory;

import com.smarthome.device.SmartDevice;

public class HomeDeviceFactory implements DeviceFactory {
    @Override
    public SmartDevice createLight(String name) {
        return new SmartDevice("Light-" + name);
    }

    @Override
    public SmartDevice createAirConditioner(String name) {
        return new SmartDevice("AC-" + name);
    }

    @Override
    public SmartDevice createCurtain(String name) {
        return new SmartDevice("Curtain-" + name);
    }
}
