package com.smarthome.state;

/**
 * 状态模式：系统状态统一接口。
 */
public interface SystemState {
    void handle(SmartHomeContext context);

    String getName();
}
