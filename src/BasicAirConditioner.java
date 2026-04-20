/**
 * BasicAirConditioner 表示基础空调设备。
 */
public class BasicAirConditioner implements SmartDevice {
    private final String name;

    public BasicAirConditioner(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void turnOn() {
        System.out.println(name + " 已开启制冷模式。");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " 已关闭。");
    }

    @Override
    public String getDescription() {
        return name + "（温控设备）";
    }
}
