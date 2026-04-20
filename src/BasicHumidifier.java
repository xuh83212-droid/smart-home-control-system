/**
 * BasicHumidifier 表示基础加湿器设备。
 */
public class BasicHumidifier implements SmartDevice {
    private final String name;

    public BasicHumidifier(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void turnOn() {
        System.out.println(name + " 已开启加湿。");
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
