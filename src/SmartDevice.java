/**
 * SmartDevice 抽象了智能家居设备的基础能力。
 * 作为多个设计模式中的核心组件，被装饰器与场景统一调用。
 */
public interface SmartDevice {
    String getName();

    void turnOn();

    void turnOff();

    String getDescription();
}
