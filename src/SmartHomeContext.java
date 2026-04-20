/**
 * SmartHomeContext 持有当前系统状态，并把触发动作委托给具体状态对象。
 */
public class SmartHomeContext {
    private HomeState currentState;

    public SmartHomeContext(HomeState initialState) {
        this.currentState = initialState;
    }

    public void setState(HomeState state) {
        this.currentState = state;
        System.out.println("系统状态切换为：" + state.getName());
    }

    public void triggerAction() {
        currentState.handle(this);
    }
}
