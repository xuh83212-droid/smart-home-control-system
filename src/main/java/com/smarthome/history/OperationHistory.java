package com.smarthome.history;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 历史记录模块：保存用户操作历史。
 */
public class OperationHistory {
    private final List<String> logs = new ArrayList<>();

    public void record(String operation) {
        logs.add(operation);
    }

    public List<String> getLogs() {
        return Collections.unmodifiableList(logs);
    }
}
