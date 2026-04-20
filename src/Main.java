import smarthome.builder.SmartScene;
import smarthome.builder.SmartSceneBuilder;
import smarthome.decorator.BreathingLightDecorator;
import smarthome.decorator.TimerDeviceDecorator;
import smarthome.device.AirConditioner;
import smarthome.device.Humidifier;
import smarthome.device.SecuritySystem;
import smarthome.device.SmartDevice;
import smarthome.device.SmartLight;
import smarthome.observer.AirConditionerObserver;
import smarthome.observer.TemperatureSensor;
import smarthome.state.PartyState;
import smarthome.state.SecurityState;
import smarthome.state.SleepState;
import smarthome.state.SmartHomeContext;
import smarthome.strategy.CustomStrategy;
import smarthome.strategy.EcoStrategy;
import smarthome.strategy.EnergyStrategy;
import smarthome.strategy.HighPerformanceStrategy;

/**
 * 智能家居控制系统示例入口：演示多种设计模式协作。
 */
public class Main {
    public static void main(String[] args) {
        // 基础设备
        SmartLight livingRoomLight = new SmartLight("客厅主灯");
        AirConditioner livingRoomAc = new AirConditioner("客厅空调");
        Humidifier livingRoomHumidifier = new Humidifier("客厅加湿器");
        SecuritySystem homeSecurity = new SecuritySystem("家庭安防系统");

        // 1) Builder 模式
        System.out.println("\n=== 1) Builder 模式：离家场景 ===");
        SmartScene awayScene = new SmartSceneBuilder()
                .sceneName("离家场景")
                .turnOff(livingRoomLight)
                .turnOff(livingRoomAc)
                .turnOff(livingRoomHumidifier)
                .turnOn(homeSecurity)
                .build();
        awayScene.execute();

        // 2) Decorator 模式
        System.out.println("\n=== 2) Decorator 模式：灯光功能增强 ===");
        SmartDevice decoratedLight = new BreathingLightDecorator(
                new TimerDeviceDecorator(livingRoomLight, 30)
        );
        System.out.println("装饰前：" + livingRoomLight.getDescription());
        System.out.println("装饰后：" + decoratedLight.getDescription());

        // 3) Strategy 模式
        System.out.println("\n=== 3) Strategy 模式：能耗策略切换 ===");
        double basePowerKw = 1.5;
        int runningHours = 4;
        showEnergy(new EcoStrategy(), basePowerKw, runningHours);
        showEnergy(new HighPerformanceStrategy(), basePowerKw, runningHours);
        showEnergy(new CustomStrategy(1.05), basePowerKw, runningHours);

        // 4) State 模式
        System.out.println("\n=== 4) State 模式：同一行为在不同状态下结果不同 ===");
        SmartHomeContext context = new SmartHomeContext();
        context.setState(new SecurityState());
        context.triggerAction();
        context.setState(new SleepState());
        context.triggerAction();
        context.setState(new PartyState());
        context.triggerAction();

        // 5) Observer 模式
        System.out.println("\n=== 5) Observer 模式：温度触发空调 ===");
        TemperatureSensor sensor = new TemperatureSensor();
        sensor.addObserver(new AirConditionerObserver(livingRoomAc));
        sensor.setTemperature(26.5);
        sensor.setTemperature(29.3);
    }

    private static void showEnergy(EnergyStrategy strategy, double basePowerKw, int runningHours) {
        double consumption = strategy.calculateEnergyConsumption(basePowerKw, runningHours);
        System.out.printf("策略[%s]：%.2fkWh%n", strategy.name(), consumption);
    }
}
