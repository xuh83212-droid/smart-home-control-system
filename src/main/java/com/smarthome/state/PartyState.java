package com.smarthome.state;

/**
 * 状态模式：派对状态。
 */
public class PartyState implements SystemState {
    @Override
    public void handle(SmartHomeContext context) {
    }

    @Override
    public String getName() {
        return "Party";
    }
}
