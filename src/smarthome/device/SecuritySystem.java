package smarthome.device;

/**
 * 具体设备：安防系统。
 */
public class SecuritySystem implements SmartDevice {
    private final String name;

    public SecuritySystem(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void turnOn() {
        System.out.println(name + " 已开启安防模式。");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " 已关闭安防模式。");
    }

    @Override
    public String getDescription() {
        return name + "（家庭安防）";
    }
}
