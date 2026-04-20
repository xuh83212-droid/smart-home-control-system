package com.smarthome.strategy;

import com.smarthome.core.SmartComponent;
import java.util.List;

public class SequentialControlStrategy implements ControlStrategy {
    @Override
    public void turnOn(List<SmartComponent> components) {
        for (SmartComponent component : components) {
            component.turnOn();
        }
    }

    @Override
    public void turnOff(List<SmartComponent> components) {
        for (SmartComponent component : components) {
            component.turnOff();
        }
    }
}
