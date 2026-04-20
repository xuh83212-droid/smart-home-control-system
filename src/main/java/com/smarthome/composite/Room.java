package com.smarthome.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式：房间节点，可包含设备或其他组件。
 */
public class Room implements HomeComponent {
    private final String name;
    private final List<HomeComponent> children = new ArrayList<>();

    public Room(String name) {
        this.name = name;
    }

    public void add(HomeComponent component) {
        children.add(component);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void display() {
    }
}
