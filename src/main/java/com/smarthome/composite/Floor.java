package com.smarthome.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式：楼层节点，可管理多个房间。
 */
public class Floor implements HomeComponent {
    private final String name;
    private final List<HomeComponent> children = new ArrayList<>();

    public Floor(String name) {
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
