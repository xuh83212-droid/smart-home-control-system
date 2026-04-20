package com.smarthome.state;

/**
 * 状态模式：睡眠状态。
 */
public class SleepState implements SystemState {
    @Override
    public void handle(SmartHomeContext context) {
    }

    @Override
    public String getName() {
        return "Sleep";
    }
}
