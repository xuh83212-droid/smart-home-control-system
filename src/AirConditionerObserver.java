/**
 * AirConditionerObserver 作为 Observer，根据温度阈值自动控制空调。
 */
public class AirConditionerObserver implements TemperatureObserver {
    private final SmartDevice airConditioner;
    private final double threshold;
    private boolean isOn;

    public AirConditionerObserver(SmartDevice airConditioner, double threshold) {
        this.airConditioner = airConditioner;
        this.threshold = threshold;
    }

    @Override
    public void update(double temperature) {
        if (temperature > threshold && !isOn) {
            System.out.println("温度超过 " + threshold + "℃，自动开启空调。");
            airConditioner.turnOn();
            isOn = true;
        } else if (temperature <= threshold && isOn) {
            System.out.println("温度不高于 " + threshold + "℃，自动关闭空调。");
            airConditioner.turnOff();
            isOn = false;
        } else {
            System.out.println("空调状态保持不变。");
        }
    }
}
