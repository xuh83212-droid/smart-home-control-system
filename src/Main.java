/**
 * Main 用于演示智能家居项目中的 Builder、Decorator、Strategy、State、Observer 设计模式。
 */
public class Main {
    public static void main(String[] args) {
        SmartDevice livingRoomLight = new BasicLight("客厅灯");
        SmartDevice airConditioner = new BasicAirConditioner("中央空调");
        SmartDevice humidifier = new BasicHumidifier("卧室加湿器");
        SecuritySystem securitySystem = new SecuritySystem("家庭安防系统");

        System.out.println("\n=== 1) Builder 模式：构建并执行离家场景 ===");
        SmartScene awayScene = new SmartSceneBuilder()
                .setSceneName("离家场景")
                .addTurnOffLight(livingRoomLight)
                .addTurnOffAirConditioner(airConditioner)
                .addTurnOffHumidifier(humidifier)
                .addArmSecurity(securitySystem)
                .build();
        awayScene.execute();

        System.out.println("\n=== 2) Decorator 模式：普通灯增强功能 ===");
        SmartDevice decoratedLight = new BreathingLightDecorator(
                new TimerDeviceDecorator(livingRoomLight, "每天 22:00 自动关闭"));
        System.out.println("装饰前：" + livingRoomLight.getDescription());
        System.out.println("装饰后：" + decoratedLight.getDescription());

        System.out.println("\n=== 3) Strategy 模式：切换能耗策略 ===");
        EnergyCalculator calculator = new EnergyCalculator(new EcoStrategy());
        double baseConsumption = 10.0;
        calculator.printConsumption(baseConsumption);
        calculator.setEnergyStrategy(new HighPerformanceStrategy());
        calculator.printConsumption(baseConsumption);
        calculator.setEnergyStrategy(new CustomStrategy(1.05));
        calculator.printConsumption(baseConsumption);

        System.out.println("\n=== 4) State 模式：相同 triggerAction 在不同状态输出不同结果 ===");
        SmartHomeContext context = new SmartHomeContext(new SecurityState());
        context.triggerAction();
        context.setState(new SleepState());
        context.triggerAction();
        context.setState(new PartyState());
        context.triggerAction();

        System.out.println("\n=== 5) Observer 模式：温度变化触发空调行为 ===");
        TemperatureSensor sensor = new TemperatureSensor();
        sensor.addObserver(new AirConditionerObserver(airConditioner, 28.0));
        sensor.setTemperature(26.5);
        sensor.setTemperature(29.2);
        sensor.setTemperature(27.8);
    }
}
