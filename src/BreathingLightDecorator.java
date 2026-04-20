/**
 * BreathingLightDecorator 为智能灯添加呼吸灯特效说明。
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
