/**
 * DeviceDecorator 是装饰器抽象基类。
 * 通过包装 SmartDevice 在不修改原类的情况下动态增强功能。
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
