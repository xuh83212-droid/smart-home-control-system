package smarthome.observer;

import smarthome.device.AirConditioner;

/**
 * Observer 具体观察者：当温度过高时自动开启空调。
 */
public class AirConditionerObserver implements TemperatureObserver {
    private static final double DEFAULT_THRESHOLD = 28.0;
    private final AirConditioner airConditioner;
    private final double threshold;

    public AirConditionerObserver(AirConditioner airConditioner) {
        this(airConditioner, DEFAULT_THRESHOLD);
    }

    public AirConditionerObserver(AirConditioner airConditioner, double threshold) {
        this.airConditioner = airConditioner;
        this.threshold = threshold;
    }

    @Override
    public void update(double temperature) {
        if (temperature > threshold) {
            System.out.println("检测到高温(" + temperature + "℃)，自动开启空调。");
            airConditioner.turnOn();
        } else {
            System.out.println("当前温度" + temperature + "℃，无需开启空调。");
        }
    }
}
