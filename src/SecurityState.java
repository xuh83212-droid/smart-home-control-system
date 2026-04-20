/**
 * SecurityState 表示安防状态下的按钮行为。
 */
public class SecurityState implements HomeState {
    @Override
    public void handle(SmartHomeContext context) {
        System.out.println("[安防模式] 检测门窗与摄像头，开启全天候监控。");
    }

    @Override
    public String getName() {
        return "安防模式";
    }
}
