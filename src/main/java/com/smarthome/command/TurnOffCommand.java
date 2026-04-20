package com.smarthome.command;

import com.smarthome.device.SmartDevice;

/**
 * 命令模式：关机命令。
 */
public class TurnOffCommand implements Command {
    private final SmartDevice device;

    public TurnOffCommand(SmartDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}
