/**
 * SleepState 表示睡眠状态下的按钮行为。
 */
public class SleepState implements HomeState {
    @Override
    public void handle(SmartHomeContext context) {
        System.out.println("[睡眠模式] 调暗灯光并进入静音提醒。");
    }

    @Override
    public String getName() {
        return "睡眠模式";
    }
}
