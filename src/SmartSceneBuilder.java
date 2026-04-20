import java.util.ArrayList;
import java.util.List;

/**
 * SmartSceneBuilder 使用 Builder 模式逐步构建复杂场景对象。
 * 调用方可按需添加步骤，最后统一 build 成可执行 SmartScene。
 */
public class SmartSceneBuilder {
    private String sceneName;
    private final List<Runnable> actions = new ArrayList<>();

    public SmartSceneBuilder setSceneName(String sceneName) {
        this.sceneName = sceneName;
        return this;
    }

    public SmartSceneBuilder addTurnOffLight(SmartDevice light) {
        actions.add(light::turnOff);
        return this;
    }

    public SmartSceneBuilder addTurnOffAirConditioner(SmartDevice airConditioner) {
        actions.add(airConditioner::turnOff);
        return this;
    }

    public SmartSceneBuilder addTurnOffHumidifier(SmartDevice humidifier) {
        actions.add(humidifier::turnOff);
        return this;
    }

    public SmartSceneBuilder addArmSecurity(SecuritySystem securitySystem) {
        actions.add(securitySystem::arm);
        return this;
    }

    public SmartScene build() {
        if (sceneName == null || sceneName.isBlank()) {
            throw new IllegalStateException("场景名称不能为空");
        }
        return new SmartScene(sceneName, actions);
    }
}
