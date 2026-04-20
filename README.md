# Smart Home Control System

本项目是一个用于课程设计的智能家居控制系统示例，覆盖了设备管理、分组控制、模式切换、智能联动、操作历史与撤销，并在实现中展示多个经典设计模式。

## 功能说明

1. **设备管理**：`DeviceManager` 负责设备注册、查询与遍历。
2. **分组控制**：`DeviceGroup` 支持把单个设备或子分组统一控制。
3. **模式切换**：`ModeContext` 配合 `HomeMode/AwayMode` 切换居家/离家状态。
4. **智能联动**：`TemperatureSensor` 通知 `TemperatureAutomationRule`，达到阈值自动触发设备。
5. **操作历史与撤销**：`OperationHistory` 记录命令执行历史并支持 `undoLast()`。

## 设计模式使用位置与设计意图

- **Abstract Factory**：`DeviceFactory` + `HomeDeviceFactory`，统一创建不同类型设备，隔离客户端与具体实例化细节。
- **Composite**：`DeviceGroup` 与 `SmartComponent`，使“单设备”和“设备组”具备一致控制接口。
- **Decorator**：`LoggingDeviceDecorator`，在不修改设备核心逻辑前提下扩展日志能力。
- **Command**：`Command`、`TurnOnCommand`、`TurnOffCommand`，把操作请求对象化，便于记录、回放、撤销。
- **Strategy**：`ControlStrategy`、`SequentialControlStrategy`、`ReverseControlStrategy`，分组控制算法可替换。
- **State**：`HomeModeState`、`HomeMode`、`AwayMode`、`ModeContext`，将不同模式行为封装为状态对象。
- **Observer**：`TemperatureSensor`（主题）与 `SensorObserver`/`TemperatureAutomationRule`（观察者），实现传感器事件驱动联动。

## 运行与验证

```bash
mvn clean test
mvn clean package
mvn exec:java -Dexec.mainClass="com.smarthome.Main"
```

## Main.java 演示内容

`Main.java` 完整演示了：
- 工厂创建设备
- 设备注册管理
- 分组与子分组控制
- 命令执行与撤销
- 控制策略切换
- 模式切换
- 传感器触发自动化规则
