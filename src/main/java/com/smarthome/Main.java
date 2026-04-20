package com.smarthome;

import com.smarthome.automation.TemperatureAutomationRule;
import com.smarthome.command.TurnOffCommand;
import com.smarthome.command.TurnOnCommand;
import com.smarthome.composite.DeviceGroup;
import com.smarthome.core.DeviceManager;
import com.smarthome.core.SmartComponent;
import com.smarthome.decorator.LoggingDeviceDecorator;
import com.smarthome.device.SmartDevice;
import com.smarthome.factory.DeviceFactory;
import com.smarthome.factory.HomeDeviceFactory;
import com.smarthome.history.OperationHistory;
import com.smarthome.mode.ModeContext;
import com.smarthome.observer.TemperatureSensor;
import com.smarthome.state.AwayMode;
import com.smarthome.state.HomeMode;
import com.smarthome.strategy.ReverseControlStrategy;

public class Main {
    public static void main(String[] args) {
        DeviceFactory factory = new HomeDeviceFactory();

        SmartComponent livingRoomLight = new LoggingDeviceDecorator(factory.createLight("LivingRoom"));
        SmartDevice bedroomAc = factory.createAirConditioner("BedRoom");
        SmartDevice balconyCurtain = factory.createCurtain("Balcony");

        DeviceManager manager = new DeviceManager();
        manager.register(livingRoomLight);
        manager.register(bedroomAc);
        manager.register(balconyCurtain);

        DeviceGroup livingArea = new DeviceGroup("LivingArea");
        livingArea.add(livingRoomLight);
        livingArea.add(balconyCurtain);

        DeviceGroup allDevices = new DeviceGroup("AllDevices");
        allDevices.add(livingArea);
        allDevices.add(bedroomAc);

        OperationHistory history = new OperationHistory();
        history.execute(new TurnOnCommand(livingRoomLight));
        history.execute(new TurnOffCommand(livingRoomLight));
        history.undoLast();

        livingArea.setStrategy(new ReverseControlStrategy());
        livingArea.turnOn();

        ModeContext modeContext = new ModeContext();
        modeContext.switchTo(new AwayMode(allDevices));
        modeContext.switchTo(new HomeMode(allDevices));

        TemperatureSensor sensor = new TemperatureSensor();
        sensor.addObserver(new TemperatureAutomationRule(30.0, bedroomAc, history));
        sensor.setTemperature(31.5);

        System.out.println("Current Mode: " + modeContext.getCurrent().name());
        System.out.println("Managed devices: " + manager.allDevices().size());
        System.out.println("Operation logs: " + history.getAuditLog());
    }
}
