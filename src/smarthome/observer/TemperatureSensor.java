package smarthome.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer Subject：温度传感器，负责维护观察者并在温度变化时通知。
 */
public class TemperatureSensor {
    private final List<TemperatureObserver> observers = new ArrayList<>();
    private double temperature;

    public void addObserver(TemperatureObserver observer) {
        observers.add(observer);
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        System.out.println("温度传感器更新：" + temperature + "℃");
        notifyObservers();
    }

    private void notifyObservers() {
        for (TemperatureObserver observer : observers) {
            observer.update(temperature);
        }
    }
}
