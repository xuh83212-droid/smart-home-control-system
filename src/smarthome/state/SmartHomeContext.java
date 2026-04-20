package smarthome.state;

/**
 * State 上下文：持有当前状态，并将行为请求委托给当前状态对象。
 */
public class SmartHomeContext {
    private SmartHomeState currentState;

    public void setState(SmartHomeState currentState) {
        this.currentState = currentState;
        System.out.println("当前状态切换为：" + currentState.getStateName());
    }

    public void triggerAction() {
        if (currentState == null) {
            System.out.println("尚未设置系统状态。");
            return;
        }
        currentState.triggerAction();
    }
}
