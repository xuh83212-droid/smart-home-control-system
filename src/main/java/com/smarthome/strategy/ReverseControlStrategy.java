package com.smarthome.strategy;

import com.smarthome.core.SmartComponent;
import java.util.List;

public class ReverseControlStrategy implements ControlStrategy {
    @Override
    public void turnOn(List<SmartComponent> components) {
        for (int i = components.size() - 1; i >= 0; i--) {
            components.get(i).turnOn();
        }
    }

    @Override
    public void turnOff(List<SmartComponent> components) {
        for (int i = components.size() - 1; i >= 0; i--) {
            components.get(i).turnOff();
        }
    }
}
