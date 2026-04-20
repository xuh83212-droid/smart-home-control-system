package smarthome.decorator;

import smarthome.device.SmartDevice;

/**
 * Decorator 抽象装饰器：包装 SmartDevice 并在不改动原类的前提下扩展功能。
 */
public abstract class DeviceDecorator implements SmartDevice {
    protected final SmartDevice wrappedDevice;

    protected DeviceDecorator(SmartDevice wrappedDevice) {
        this.wrappedDevice = wrappedDevice;
    }

    @Override
    public String getName() {
        return wrappedDevice.getName();
    }

    @Override
    public void turnOn() {
        wrappedDevice.turnOn();
    }

    @Override
    public void turnOff() {
        wrappedDevice.turnOff();
    }

    @Override
    public String getDescription() {
        return wrappedDevice.getDescription();
    }
}
