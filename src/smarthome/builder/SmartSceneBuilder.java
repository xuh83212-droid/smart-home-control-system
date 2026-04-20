package smarthome.builder;

import java.util.ArrayList;
import java.util.List;
import smarthome.device.SmartDevice;

/**
 * Builder：通过链式调用逐步构建智能场景。
 * 将复杂对象的创建过程与表示分离。
 */
public class SmartSceneBuilder {
    private String sceneName = "未命名场景";
    private final List<SmartScene.SceneAction> actions = new ArrayList<>();

    public SmartSceneBuilder sceneName(String sceneName) {
        this.sceneName = sceneName;
        return this;
    }

    public SmartSceneBuilder turnOff(SmartDevice device) {
        actions.add(new SmartScene.SceneAction("关闭" + device.getName(), device::turnOff));
        return this;
    }

    public SmartSceneBuilder turnOn(SmartDevice device) {
        actions.add(new SmartScene.SceneAction("开启" + device.getName(), device::turnOn));
        return this;
    }

    public SmartScene build() {
        return new SmartScene(sceneName, actions);
    }
}
