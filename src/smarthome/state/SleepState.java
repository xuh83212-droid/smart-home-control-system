package smarthome.state;

/**
 * 具体状态：睡眠模式下，按键触发夜间静音与柔光。
 */
public class SleepState implements SmartHomeState {
    @Override
    public void triggerAction() {
        System.out.println("[睡眠模式] 调暗卧室灯光并关闭非必要通知。");
    }

    @Override
    public String getStateName() {
        return "睡眠模式";
    }
}
