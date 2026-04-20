package smarthome.device;

/**
 * 具体设备：空调。
 */
public class AirConditioner implements SmartDevice {
    private final String name;

    public AirConditioner(String name) {
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
