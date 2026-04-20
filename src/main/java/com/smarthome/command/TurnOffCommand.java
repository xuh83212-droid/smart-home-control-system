package com.smarthome.command;

import com.smarthome.core.SmartComponent;

public class TurnOffCommand implements Command {
    private final SmartComponent component;

    public TurnOffCommand(SmartComponent component) {
        this.component = component;
    }

    @Override
    public void execute() {
        component.turnOff();
    }

    @Override
    public void undo() {
        component.turnOn();
    }

    @Override
    public String description() {
        return "TurnOff " + component.getName();
    }
}
