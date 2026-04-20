package com.smarthome;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.smarthome.automation.TemperatureAutomationRule;
import com.smarthome.command.TurnOffCommand;
import com.smarthome.command.TurnOnCommand;
import com.smarthome.composite.DeviceGroup;
import com.smarthome.core.DeviceManager;
import com.smarthome.device.SmartDevice;
import com.smarthome.factory.HomeDeviceFactory;
import com.smarthome.history.OperationHistory;
import com.smarthome.mode.ModeContext;
import com.smarthome.observer.TemperatureSensor;
import com.smarthome.state.AwayMode;
import com.smarthome.state.HomeMode;
import org.junit.jupiter.api.Test;

class SmartHomeSystemTest {
    @Test
    void shouldSupportAllRequiredCapabilities() {
        HomeDeviceFactory factory = new HomeDeviceFactory();
        SmartDevice light = factory.createLight("Test");
        SmartDevice ac = factory.createAirConditioner("Test");

        DeviceManager manager = new DeviceManager();
        manager.register(light);
        manager.register(ac);
        assertEquals(2, manager.allDevices().size());

        DeviceGroup group = new DeviceGroup("TestGroup");
        group.add(light);
        group.add(ac);

        OperationHistory history = new OperationHistory();
        history.execute(new TurnOnCommand(group));
        assertTrue(light.isOn());
        assertTrue(ac.isOn());

        history.execute(new TurnOffCommand(group));
        assertFalse(light.isOn());
        history.undoLast();
        assertTrue(light.isOn());

        ModeContext context = new ModeContext();
        context.switchTo(new AwayMode(group));
        assertFalse(group.isOn());
        context.switchTo(new HomeMode(group));
        assertTrue(group.isOn());

        TemperatureSensor sensor = new TemperatureSensor();
        sensor.addObserver(new TemperatureAutomationRule(28, ac, history));
        ac.turnOff();
        sensor.setTemperature(29);
        assertTrue(ac.isOn());
    }
}
