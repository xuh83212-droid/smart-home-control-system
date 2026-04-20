package smarthome.observer;

/**
 * Observer 抽象观察者：订阅温度变化事件。
 */
public interface TemperatureObserver {
    void update(double temperature);
}
