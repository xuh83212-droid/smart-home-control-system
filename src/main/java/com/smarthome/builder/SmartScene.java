package com.smarthome.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 建造者模式：智能场景实体。
 */
public class SmartScene {
    private final String name;
    private final List<String> actions;

    public SmartScene(String name, List<String> actions) {
        this.name = name;
        this.actions = new ArrayList<>(actions);
    }

    public String getName() {
        return name;
    }

    public List<String> getActions() {
        return Collections.unmodifiableList(actions);
    }
}
