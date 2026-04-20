package com.smarthome.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式：用于逐步构建智能场景对象。
 */
public class SmartSceneBuilder {
    private String name;
    private final List<String> actions = new ArrayList<>();

    public SmartSceneBuilder name(String name) {
        this.name = name;
        return this;
    }

    public SmartSceneBuilder addAction(String action) {
        actions.add(action);
        return this;
    }

    public SmartScene build() {
        return new SmartScene(name, actions);
    }
}
