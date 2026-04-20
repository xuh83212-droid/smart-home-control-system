package smarthome.device;

/**
 * 具体设备：智能灯，实现基础开关和描述能力。
 */
public class SmartLight implements SmartDevice {
    private final String name;

    public SmartLight(String name) {
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
        return name + "（基础照明）";
    }
}
