package smarthome.state;

/**
 * 具体状态：安防模式下，按键触发布防巡检。
 */
public class SecurityState implements SmartHomeState {
    @Override
    public void triggerAction() {
        System.out.println("[安防模式] 启动门窗传感器巡检并开启报警联动。");
    }

    @Override
    public String getStateName() {
        return "安防模式";
    }
}
