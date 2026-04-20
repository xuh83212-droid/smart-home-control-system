package smarthome.decorator;

import smarthome.device.SmartDevice;

/**
 * 具体装饰器：为灯光类设备增加呼吸灯特效描述。
 */
public class BreathingLightDecorator extends DeviceDecorator {
    public BreathingLightDecorator(SmartDevice wrappedDevice) {
        super(wrappedDevice);
    }

    @Override
    public String getDescription() {
        return wrappedDevice.getDescription() + " + 呼吸灯特效";
    }
}
