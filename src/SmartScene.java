import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SmartScene 表示一个可执行的智能家居场景。
 * 通过聚合操作步骤，把多个设备行为编排为一键执行流程。
 */
public class SmartScene {
    private final String name;
    private final List<Runnable> actions;

    public SmartScene(String name, List<Runnable> actions) {
        this.name = name;
        this.actions = new ArrayList<>(actions);
    }

    public String getName() {
        return name;
    }

    public List<Runnable> getActions() {
        return Collections.unmodifiableList(actions);
    }

    public void execute() {
        System.out.println("开始执行场景：" + name);
        for (Runnable action : actions) {
            action.run();
        }
        System.out.println("场景执行完成：" + name);
    }
}
