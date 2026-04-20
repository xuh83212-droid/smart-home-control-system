package com.smarthome.automation;

import com.smarthome.command.TurnOnCommand;
import com.smarthome.core.SmartComponent;
import com.smarthome.history.OperationHistory;
import com.smarthome.observer.SensorObserver;

public class TemperatureAutomationRule implements SensorObserver {
    private final double threshold;
    private final SmartComponent target;
    private final OperationHistory history;

    public TemperatureAutomationRule(double threshold, SmartComponent target, OperationHistory history) {
        this.threshold = threshold;
        this.target = target;
        this.history = history;
    }

    @Override
    public void onSensorChanged(String sensorType, double value) {
        if ("temperature".equals(sensorType) && value >= threshold && !target.isOn()) {
            history.execute(new TurnOnCommand(target));
        }
    }
}
