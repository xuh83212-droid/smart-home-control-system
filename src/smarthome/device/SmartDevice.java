package smarthome.device;

/**
 * 设备抽象：统一定义智能家居设备的基本控制能力。
 */
public interface SmartDevice {
    String getName();

    void turnOn();

    void turnOff();

    String getDescription();
}
