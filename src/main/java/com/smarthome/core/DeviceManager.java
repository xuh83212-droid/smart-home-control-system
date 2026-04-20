package com.smarthome.core;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class DeviceManager {
    private final Map<String, SmartComponent> devices = new LinkedHashMap<>();

    public void register(SmartComponent device) {
        devices.put(device.getName(), device);
    }

    public Optional<SmartComponent> findByName(String name) {
        return Optional.ofNullable(devices.get(name));
    }

    public Collection<SmartComponent> allDevices() {
        return devices.values();
    }
}
