package com.smarthome.command;

import com.smarthome.core.SmartComponent;

public class TurnOnCommand implements Command {
    private final SmartComponent component;

    public TurnOnCommand(SmartComponent component) {
        this.component = component;
    }

    @Override
    public void execute() {
        component.turnOn();
    }

    @Override
    public void undo() {
        component.turnOff();
    }

    @Override
    public String description() {
        return "TurnOn " + component.getName();
    }
}
