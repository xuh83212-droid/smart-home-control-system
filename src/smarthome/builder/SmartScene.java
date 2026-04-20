package smarthome.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder 产物：智能场景。
 * 封装一组可顺序执行的家居动作，便于复用复杂流程。
 */
public class SmartScene {
    private final String name;
    private final List<SceneAction> actions;

    public SmartScene(String name, List<SceneAction> actions) {
        this.name = name;
        this.actions = new ArrayList<>(actions);
    }

    public void execute() {
        System.out.println("执行场景：" + name);
        for (SceneAction action : actions) {
            System.out.println("- " + action.description());
            action.runnable().run();
        }
    }

    public record SceneAction(String description, Runnable runnable) {
    }
}
