package com.smarthome.state;

/**
 * 状态模式：上下文，维护当前系统状态。
 */
public class SmartHomeContext {
    private SystemState currentState;

    public SmartHomeContext(SystemState currentState) {
        this.currentState = currentState;
    }

    public void setState(SystemState state) {
        this.currentState = state;
    }

    public void request() {
        if (currentState != null) {
            currentState.handle(this);
        }
    }

    public String getCurrentStateName() {
        return currentState == null ? "Unknown" : currentState.getName();
    }
}
