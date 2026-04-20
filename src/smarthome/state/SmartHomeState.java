package smarthome.state;

/**
 * State 抽象状态：定义系统在不同模式下的统一行为入口。
 */
public interface SmartHomeState {
    void triggerAction();

    String getStateName();
}
