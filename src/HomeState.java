/**
 * HomeState 定义状态模式下统一的行为接口。
 */
public interface HomeState {
    void handle(SmartHomeContext context);

    String getName();
}
