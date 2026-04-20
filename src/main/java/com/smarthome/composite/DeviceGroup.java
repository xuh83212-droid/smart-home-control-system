package com.smarthome.composite;

import com.smarthome.core.SmartComponent;
import com.smarthome.strategy.ControlStrategy;
import com.smarthome.strategy.SequentialControlStrategy;
import java.util.ArrayList;
import java.util.List;

public class DeviceGroup implements SmartComponent {
    private final String name;
    private final List<SmartComponent> children = new ArrayList<>();
    private ControlStrategy strategy = new SequentialControlStrategy();

    public DeviceGroup(String name) {
        this.name = name;
    }

    public void add(SmartComponent component) {
        children.add(component);
    }

    public void setStrategy(ControlStrategy strategy) {
        this.strategy = strategy;
    }

    public List<SmartComponent> getChildren() {
        return List.copyOf(children);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isOn() {
        return children.stream().allMatch(SmartComponent::isOn);
    }

    @Override
    public void turnOn() {
        strategy.turnOn(children);
    }

    @Override
    public void turnOff() {
        strategy.turnOff(children);
    }
}
