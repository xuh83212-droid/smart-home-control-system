/**
 * SecuritySystem 表示家庭安防系统，提供布防/撤防能力。
 */
public class SecuritySystem {
    private final String name;

    public SecuritySystem(String name) {
        this.name = name;
    }

    public void arm() {
        System.out.println(name + " 已开启安防模式。");
    }

    public void disarm() {
        System.out.println(name + " 已关闭安防模式。");
    }
}
