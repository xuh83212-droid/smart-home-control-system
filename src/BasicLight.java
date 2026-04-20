/**
 * BasicLight 表示一个基础智能灯实现。
 */
public class BasicLight implements SmartDevice {
    private final String name;

    public BasicLight(String name) {
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
        return name + "（普通照明）";
    }
}
