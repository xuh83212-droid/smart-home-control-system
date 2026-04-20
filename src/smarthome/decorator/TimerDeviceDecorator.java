package smarthome.decorator;

import smarthome.device.SmartDevice;

/**
 * 具体装饰器：为任意设备增加定时开关能力描述。
 */
public class TimerDeviceDecorator extends DeviceDecorator {
    private final int timerMinutes;

    public TimerDeviceDecorator(SmartDevice wrappedDevice, int timerMinutes) {
        super(wrappedDevice);
        this.timerMinutes = timerMinutes;
    }

    @Override
    public String getDescription() {
        return wrappedDevice.getDescription() + " + 定时" + timerMinutes + "分钟自动开关";
    }
}
