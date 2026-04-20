package com.smarthome.state;

/**
 * 状态模式：安防状态。
 */
public class SecurityState implements SystemState {
    @Override
    public void handle(SmartHomeContext context) {
    }

    @Override
    public String getName() {
        return "Security";
    }
}
