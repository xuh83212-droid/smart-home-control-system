package com.smarthome.factory;

import com.smarthome.device.SmartDevice;

public interface DeviceFactory {
    SmartDevice createLight(String name);
    SmartDevice createAirConditioner(String name);
    SmartDevice createCurtain(String name);
}
