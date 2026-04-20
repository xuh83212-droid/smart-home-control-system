import java.util.ArrayList;
import java.util.List;

/**
 * TemperatureSensor 作为 Subject，负责在温度变化时通知所有观察者。
 */
public class TemperatureSensor {
    private final List<TemperatureObserver> observers = new ArrayList<>();
    private double temperature;

    public void addObserver(TemperatureObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TemperatureObserver observer) {
        observers.remove(observer);
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        System.out.println("温度传感器读数更新为：" + temperature + "℃");
        notifyObservers();
    }

    private void notifyObservers() {
        for (TemperatureObserver observer : observers) {
            observer.update(temperature);
        }
    }
}
