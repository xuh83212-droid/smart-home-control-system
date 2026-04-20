/**
 * TimerDeviceDecorator 为设备添加定时开关说明。
 */
public class TimerDeviceDecorator extends DeviceDecorator {
    private final String schedule;

    public TimerDeviceDecorator(SmartDevice wrappedDevice, String schedule) {
        super(wrappedDevice);
        this.schedule = schedule;
    }

    @Override
    public String getDescription() {
        return wrappedDevice.getDescription() + " + 定时任务(" + schedule + ")";
    }
}
