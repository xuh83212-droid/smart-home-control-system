package smarthome.device;

/**
 * 具体设备：加湿器。
 */
public class Humidifier implements SmartDevice {
    private final String name;

    public Humidifier(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void turnOn() {
        System.out.println(name + " 已开启。");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " 已关闭。");
    }

    @Override
    public String getDescription() {
        return name + "（湿度调节）";
    }
}
