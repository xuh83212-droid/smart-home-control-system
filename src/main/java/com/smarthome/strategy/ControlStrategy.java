package com.smarthome.strategy;

import com.smarthome.core.SmartComponent;
import java.util.List;

public interface ControlStrategy {
    void turnOn(List<SmartComponent> components);
    void turnOff(List<SmartComponent> components);
}
