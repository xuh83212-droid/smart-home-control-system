package com.smarthome.command;

import com.smarthome.device.SmartDevice;

/**
 * 命令模式：开机命令。
 */
public class TurnOnCommand implements Command {
    private final SmartDevice device;

    public TurnOnCommand(SmartDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}
